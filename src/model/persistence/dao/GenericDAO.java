package model.persistence.dao;

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
            statement.setLong(1, id);
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
	public void save(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	protected abstract T convertToEntity(ResultSet resultSet) throws SQLException;
}
