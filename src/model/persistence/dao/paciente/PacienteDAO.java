package model.persistence.dao.paciente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.entities.Paciente;
import model.enums.EnumGenero;
import model.persistence.dao.GenericDAO;
import model.persistence.dao.interfaces.IPacienteDAO;

public class PacienteDAO extends GenericDAO<PacienteFullDTO> implements IPacienteDAO {

	public PacienteDAO() {
		super("paciente");
	}

	@Override
	public int save(Paciente paciente) throws SQLException {
		try {
			connection.setAutoCommit(false);

			int enderecoId = super.save(paciente.getPessoa().getEndereco(), "endereco");
			int convenioId = super.save(paciente.getConvenio(), "convenio");
			int historicoMedicoId = super.save(paciente.getHistoricoMedico(), "historicoMedico");

			PessoaDTO pessoaDTO = new PessoaDTO(paciente.getPessoa().getNome(), paciente.getPessoa().getCpf(),
					paciente.getPessoa().getRg(), paciente.getPessoa().getDataNascimento(),
					paciente.getPessoa().getCelular(), paciente.getPessoa().getTelefone(),
					paciente.getPessoa().getEmail(), paciente.getPessoa().getGenero().getValue(), enderecoId);
			int pessoaId = super.save(pessoaDTO, "pessoa");

			PacienteDTO pacienteDAO = new PacienteDTO(paciente.getAltura(), paciente.isFumante(),
					paciente.isMarcaPasso(), convenioId, historicoMedicoId, pessoaId);
			int pacienteId = super.save(pacienteDAO, "paciente");

			connection.commit();

			return pacienteId;
		} catch (SQLException e) {
			throw new SQLException("Erro ao salvar paciente: " + e.getMessage());
		}
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub

	}

	@Override
	public PacienteFullDTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException {
		int idPaciente = resultSet.getInt("paciente_id");

		String nome = resultSet.getString("nome");
		String cpf = resultSet.getString("cpf");
		String rg = resultSet.getString("rg");
		Object dbSqlDate = resultSet.getObject("dataNascimento");
		LocalDate dataNascimento = LocalDate.parse(dbSqlDate.toString());
		long celular = resultSet.getLong("celular");
		long telefone = resultSet.getLong("telefone");
		String email = resultSet.getString("email");
		EnumGenero genero = EnumGenero.fromInt(resultSet.getInt("genero"));

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
		String condicaoMedica = resultSet.getString("condicaoMedica");

		return new PacienteFullDTO(idPaciente, nome, cpf, rg, dataNascimento, celular, telefone, email, genero, cep,
				estado, cidade, bairro, rua, numero, complemento, altura, fumante, marcaPasso, numeroCarteirinha,
				prestadora, plano, alergias, medicamentos, condicaoMedica);
	}
}
