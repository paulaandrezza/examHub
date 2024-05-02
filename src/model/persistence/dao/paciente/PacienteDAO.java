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

import model.entities.Convenio;
import model.entities.Endereco;
import model.entities.HistoricoMedico;
import model.entities.Paciente;
import model.entities.Pessoa;
import model.enums.Genero;
import model.exceptions.EntityNotFoundException;
import model.persistence.DatabaseConnection;
import model.persistence.dao.GenericDAO;
import model.persistence.dao.interfaces.ICommonDAO;
import model.persistence.dao.interfaces.IGenericDAO;
import model.persistence.dao.interfaces.IPacienteDAO;

public class PacienteDAO extends GenericDAO<PacienteFullDTO> implements ICommonDAO<PacienteFullDTO>, IPacienteDAO {

	public PacienteDAO() {
		super("paciente");
	}
	
	@Override
	public int save(Endereco endereco, Convenio convenio, HistoricoMedico historicoMedico, Pessoa pessoa, Paciente paciente) {
	    try {
	        connection.setAutoCommit(false);

	        int enderecoId = super.save(endereco, "endereco");
	        int convenioId = super.save(convenio, "convenio");
	        int historicoMedicoId = super.save(historicoMedico, "historicoMedico");
	        
	        PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.getCelular(), pessoa.getTelefone(), pessoa.getEmail(), pessoa.getGenero().getValue(), enderecoId);
	        int pessoaId = super.save(pessoaDTO, "pessoa");
	        
	        PacienteDTO pacienteDAO = new PacienteDTO(paciente.getAltura(), paciente.isFumante(), paciente.isMarcaPasso(), convenioId, historicoMedicoId, pessoaId);
	        int pacienteId = super.save(pacienteDAO, "paciente");

	        connection.commit();

	        return pacienteId;
	    } catch (SQLException e) {
	        System.err.println("Erro ao salvar paciente: " + e.getMessage());
	        try {
	            connection.rollback();
	        } catch (SQLException ex) {
	            System.err.println("Erro ao reverter transação: " + ex.getMessage());
	        }
	        return -1;
	    }
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
	public PacienteFullDTO convertToEntity(ResultSet resultSet) throws SQLException {
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

        return new PacienteFullDTO(
            idPaciente, nome, cpf, dataNascimento, celular, telefone, email, genero,
            cep, estado, cidade, bairro, rua, numero, complemento, altura, fumante,
            marcaPasso, numeroCarteirinha, prestadora, plano, alergias, medicamentos, prescricao
        );
	}
}
