package model.persistence.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.exceptions.EmailNotFoundException;
import model.persistence.DatabaseConnection;

public class AuthDAO {
	protected Connection connection;

	public AuthDAO() {
		this.connection = DatabaseConnection.getConnection();
	}

	public FuncionarioDTO getPessoa(String emailCorporativo) throws EmailNotFoundException, SQLException {
		String query = "SELECT * FROM Funcionario WHERE emailCorporativo = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setObject(1, emailCorporativo);
			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return convertResultSetToEntityDTO(resultSet);
				} else {
					throw new EmailNotFoundException(emailCorporativo);
				}
			}
		} catch (SQLException e) {
			throw e;
		}
	}

	public FuncionarioDTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException {
		return new FuncionarioDTO(resultSet.getInt("id"), resultSet.getString("emailCorporativo"),
				resultSet.getString("senha"), resultSet.getInt("tipoFuncionario"), resultSet.getInt("pessoa_id"));
	}
}
