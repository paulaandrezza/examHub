package model.persistence.dao.paciente;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.enums.Genero;
import model.exceptions.EntityNotFoundException;
import model.persistence.DatabaseConnection;
import model.persistence.dao.GenericDAO;
import model.persistence.dao.interfaces.ICommonDAO;
import model.persistence.dao.interfaces.IGenericDAO;

public class PacienteDAO extends GenericDAO<PacienteDTO> implements ICommonDAO<PacienteDTO> {

	public PacienteDAO() {
		super("paciente");
	}

	@Override
	public int save(PacienteDTO t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PacienteDTO convertToEntity(ResultSet resultSet) throws SQLException {
		int idPaciente = resultSet.getInt("paciente_id");
		
        String nome = resultSet.getString("nome");
        String cpf = resultSet.getString("cpf");
        java.util.Date dataNascimento = new java.util.Date();
        long celular = resultSet.getLong("celular");
        long telefone = resultSet.getLong("telefone");
        String email = resultSet.getString("email");
        Genero genero = Genero.fromInt(resultSet.getInt("genero"));

        int cep = resultSet.getInt("cep");
        String estado = resultSet.getString("estado");
        String cidade = resultSet.getString("cidade");
        String bairro = resultSet.getString("bairro");
        String rua = resultSet.getString("rua");
        String numero = resultSet.getString("numero");
        String complemento = resultSet.getString("complemento");

        float altura = resultSet.getFloat("altura");
        boolean fumante = resultSet.getBoolean("fumante");
        boolean marcaPasso = resultSet.getBoolean("marcaPasso");

        int numeroCarteirinha = resultSet.getInt("numeroCarteirinha");
        String prestadora = resultSet.getString("prestadora");
        String plano = resultSet.getString("plano");

        String alergias = resultSet.getString("alergias");
        String medicamentos = resultSet.getString("medicamentos");
        String prescricao = resultSet.getString("prescricao");

        return new PacienteDTO(
            idPaciente, nome, cpf, dataNascimento, celular, telefone, email, genero,
            cep, estado, cidade, bairro, rua, numero, complemento, altura, fumante,
            marcaPasso, numeroCarteirinha, prestadora, plano, alergias, medicamentos, prescricao
        );
	}
}
