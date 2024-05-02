package model.persistence.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.exceptions.EntityNotFoundException;
import model.persistence.DatabaseConnection;
import model.persistence.dao.interfaces.IGenericDAO;
import model.persistence.dao.paciente.PacienteDTO;

public abstract class GenericDAO<T> implements IGenericDAO<T> {
	protected Connection connection;
	private String sqlQuery;
	private String fileName;

    public GenericDAO(String fileName) {
        this.connection = DatabaseConnection.getConnection();
        this.fileName = fileName;
        this.sqlQuery = DatabaseConnection.loadSQL("resources/sql/querys/" + fileName + ".sql");
    }

    @Override
	public List<T> getAll() {
        List<T> list = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                T entity = convertToEntity(resultSet);
                list.add(entity);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao executar consulta: " + e.getMessage());
        }
        return list;
    }
	
	protected abstract T convertToEntity(ResultSet resultSet) throws SQLException;
}
