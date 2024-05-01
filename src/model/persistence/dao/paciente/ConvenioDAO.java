package model.persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.entities.Convenio;
import model.entities.Endereco;

public class ConveioDAO extends GenericDAO<Convenio> {

	public ConveioDAO() {
		super("Convenio");
	}

	@Override
	protected Convenio convertToEntity(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		int numeroCarteirinha = resultSet.getInt("numeroCarteirinha");
		String prestadora = resultSet.getString("prestadora");
		String plano = resultSet.getString("plano");
		return new Convenio(id, numeroCarteirinha, prestadora, plano);
	}

}
