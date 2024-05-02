package model.persistence.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.persistence.DatabaseConnection;
import model.persistence.dao.interfaces.IGenericDAO;

public abstract class GenericDAO<DTO> implements IGenericDAO<DTO> {
	protected Connection connection;
	private String sqlQuery;
	private String tableName;

	public GenericDAO(String tableName) {
		this.connection = DatabaseConnection.getConnection();
		this.tableName = tableName;
		this.sqlQuery = DatabaseConnection.loadSQL("resources/sql/querys/" + tableName + ".sql");
	}

	@Override
	public List<DTO> getAll() {
		List<DTO> list = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				DTO entity = convertResultSetToEntityDTO(resultSet);
				list.add(entity);
			}
		} catch (SQLException e) {
			System.err.println("Erro ao executar consulta: " + e.getMessage());
		}
		return list;
	}

	@Override
	public int save(Object entity, String tableName) throws SQLException {
		StringBuilder columns = new StringBuilder();
		StringBuilder values = new StringBuilder();
		List<Object> valueList = new ArrayList<>();

		Field[] fields = entity.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			try {
				if (columns.length() > 0) {
					columns.append(", ");
					values.append(", ");
				}
				columns.append(field.getName());
				values.append("?");
				valueList.add(field.get(entity));
			} catch (IllegalAccessException e) {
				System.err.println("Falha no acesso ao campo: " + e.getMessage());
			}
		}

		String sql = "INSERT INTO " + tableName + " (" + columns.toString() + ") VALUES (" + values.toString() + ")";
		PreparedStatement statement = connection.prepareStatement(sql);
		for (int i = 0; i < valueList.size(); i++) {
			statement.setObject(i + 1, valueList.get(i));
		}
		int affectedRows = statement.executeUpdate();
		if (affectedRows == 0) {
			throw new SQLException("Creating" + tableName + "failed, no rows affected.");
		}

		try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				return generatedKeys.getInt(1);
			} else {
				throw new SQLException("Creating" + tableName + "failed, no ID obtained.");
			}
		}
	}

	@Override
	public List<DTO> findByField(String fieldName, Object fieldValue) throws SQLException {
		List<DTO> resultList = new ArrayList<>();
		String query = sqlQuery + " WHERE " + fieldName + " = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setObject(1, fieldValue);
			try (ResultSet resultSet = statement.executeQuery()) {
				while (resultSet.next()) {
					DTO entity = convertResultSetToEntityDTO(resultSet);
					resultList.add(entity);
				}
			}
		} catch (SQLException e) {
			System.err.println("Erro ao executar consulta: " + e.getMessage());
			throw e;
		}
		return resultList;
	}

	@Override
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM " + tableName + " WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			statement.setInt(1, id);
			int affectedRows = statement.executeUpdate();
			connection.commit();
			if (affectedRows == 0) {
				throw new SQLException("Deleting failed, no rows affected.");
			}
		}
	}

	protected abstract DTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException;
}
