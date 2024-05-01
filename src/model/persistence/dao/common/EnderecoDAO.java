package model.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Endereco;

public class EnderecoDAO extends GenericDAO<Endereco> {

	public EnderecoDAO() {
		super("Endereco");
	}

	@Override
	protected Endereco convertToEntity(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		int cep = resultSet.getInt("cep");
		String estado = resultSet.getString("estado");
		String cidade = resultSet.getString("cidade");
		String bairro = resultSet.getString("bairro");
		String rua = resultSet.getString("rua");
		String numero = resultSet.getString("numero");
		String complemento = resultSet.getString("complemento");
		return new Endereco(id, cep, estado, cidade, bairro, rua, numero, complemento);
	}

}
