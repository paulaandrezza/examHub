package model.persistence.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.persistence.DatabaseConnection;
import model.persistence.dao.interfaces.IGenericDAO;

public abstract class GenericDAO<T> implements IGenericDAO<T> {
	protected Connection connection;
	private String tableName;

    public GenericDAO(String tableName) {
        this.connection = DatabaseConnection.getConnection();
        this.tableName = tableName;
    }

	@Override
	public Optional<T> get(int id) {
		String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                T entity = convertToEntity(resultSet);
                return Optional.of(entity);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return Optional.empty();
	}

	@Override
	public List<T> getAll() {
		List<T> list = new ArrayList();
        String sql = "SELECT * FROM " + tableName;
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                T entity = convertToEntity(resultSet);
                list.add(entity);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;
	}

	@Override
	public int save(T t) {
	    StringBuilder columns = new StringBuilder();
	    StringBuilder values = new StringBuilder();
	    List<Object> valueList = new ArrayList<>();

	    Field[] fields = t.getClass().getDeclaredFields();
	    for (Field field : fields) {
	        field.setAccessible(true);
	        try {
	            if (columns.length() > 0) {
	                columns.append(", ");
	                values.append(", ");
	            }
	            columns.append(field.getName());
	            values.append("?");
	            valueList.add(field.get(t));
	        } catch (IllegalAccessException e) {
	            System.err.println("Falha no acesso ao campo: " + e.getMessage());
	        }
	    }

	    String sql = "INSERT INTO " + tableName + " (" + columns.toString() + ") VALUES (" + values.toString() + ")";
	    try (PreparedStatement statement = connection.prepareStatement(sql)) {
	        for (int i = 0; i < valueList.size(); i++) {
	            statement.setObject(i + 1, valueList.get(i));
	        }
	        int affectedRows = statement.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                return generatedKeys.getInt(1);  // Retorna o ID gerado para o objeto criado
	            } else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }
	    } catch (SQLException e) {
	        System.err.println("Erro ao salvar o objeto: " + e.getMessage());
	        return -1;
	    }
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return;
	}
	
	protected abstract T convertToEntity(ResultSet resultSet) throws SQLException;
}
