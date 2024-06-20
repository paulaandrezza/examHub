package model.persistence.dao.paciente;

import java.sql.PreparedStatement;
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

			PessoaPacienteDTO pessoaDTO = new PessoaPacienteDTO(paciente.getPessoa().getNome(),
					paciente.getPessoa().getCpf(), paciente.getPessoa().getRg(),
					paciente.getPessoa().getDataNascimento(), paciente.getPessoa().getCelular(),
					paciente.getPessoa().getTelefone(), paciente.getPessoa().getEmail(),
					paciente.getPessoa().getGenero().getValue(), enderecoId);

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

	public void update(PacienteFullDTO pacienteFullDTO) throws SQLException {
		try {
			connection.setAutoCommit(false);

			updateEndereco(pacienteFullDTO);
			updateConvenio(pacienteFullDTO);
			updateHistoricoMedico(pacienteFullDTO);
			updatePessoa(pacienteFullDTO);
			updatePaciente(pacienteFullDTO);

			connection.commit();
		} catch (SQLException e) {
			connection.rollback();
			throw new SQLException("Erro ao atualizar paciente: " + e.getMessage());
		}
	}

	private void updateEndereco(PacienteFullDTO pacienteFullDTO) throws SQLException {
		String sql = "UPDATE endereco SET cep = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, complemento = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, pacienteFullDTO.getCep());
			statement.setString(2, pacienteFullDTO.getEstado());
			statement.setString(3, pacienteFullDTO.getCidade());
			statement.setString(4, pacienteFullDTO.getBairro());
			statement.setString(5, pacienteFullDTO.getRua());
			statement.setString(6, pacienteFullDTO.getNumero());
			statement.setString(7, pacienteFullDTO.getComplemento());
			statement.setInt(8, pacienteFullDTO.getIdEndereco());
			statement.executeUpdate();
		}
	}

	private void updateConvenio(PacienteFullDTO pacienteFullDTO) throws SQLException {
		String sql = "UPDATE convenio SET numeroCarteirinha = ?, prestadora = ?, plano = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, pacienteFullDTO.getNumeroCarteirinha());
			statement.setString(2, pacienteFullDTO.getPrestadora());
			statement.setString(3, pacienteFullDTO.getPlano());
			statement.setInt(4, pacienteFullDTO.getIdConvenio());
			statement.executeUpdate();
		}
	}

	private void updateHistoricoMedico(PacienteFullDTO pacienteFullDTO) throws SQLException {
		String sql = "UPDATE historicoMedico SET alergias = ?, medicamentos = ?, condicaoMedica = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, pacienteFullDTO.getAlergias());
			statement.setString(2, pacienteFullDTO.getMedicamentos());
			statement.setString(3, pacienteFullDTO.getCondicaoMedica());
			statement.setInt(4, pacienteFullDTO.getIdHistoricoMedico());
			statement.executeUpdate();
		}
	}

	private void updatePessoa(PacienteFullDTO pacienteFullDTO) throws SQLException {
		String sql = "UPDATE pessoa SET nome = ?, cpf = ?, rg = ?, dataNascimento = ?, celular = ?, telefone = ?, email = ?, genero = ?, endereco_id = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, pacienteFullDTO.getNome());
			statement.setString(2, pacienteFullDTO.getCpf());
			statement.setString(3, pacienteFullDTO.getRg());
			statement.setObject(4, pacienteFullDTO.getDataNascimento());
			statement.setLong(5, pacienteFullDTO.getCelular());
			statement.setLong(6, pacienteFullDTO.getTelefone());
			statement.setString(7, pacienteFullDTO.getEmail());
			statement.setInt(8, pacienteFullDTO.getGenero().getValue());
			statement.setInt(9, pacienteFullDTO.getIdEndereco());
			statement.setInt(10, pacienteFullDTO.getIdPessoa());
			statement.executeUpdate();
		}
	}

	private void updatePaciente(PacienteFullDTO pacienteFullDTO) throws SQLException {
		String sql = "UPDATE paciente SET altura = ?, fumante = ?, marcaPasso = ?, convenio_id = ?, historicoMedico_id = ?, pessoa_id = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setFloat(1, pacienteFullDTO.getAltura());
			statement.setBoolean(2, pacienteFullDTO.isFumante());
			statement.setBoolean(3, pacienteFullDTO.isMarcaPasso());
			statement.setInt(4, pacienteFullDTO.getIdConvenio());
			statement.setInt(5, pacienteFullDTO.getIdHistoricoMedico());
			statement.setInt(6, pacienteFullDTO.getIdPessoa());
			statement.setInt(7, pacienteFullDTO.getIdPaciente());
			statement.executeUpdate();
		}
	}

	public void delete(int paciente_id) throws SQLException {
		super.update("paciente", "isDeleted", true, paciente_id);
	}

	@Override
	public PacienteFullDTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException {

		int idPessoa = resultSet.getInt("pessoa_id");
		String nome = resultSet.getString("nome");
		String cpf = resultSet.getString("cpf");
		String rg = resultSet.getString("rg");
		Object dbSqlDate = resultSet.getObject("dataNascimento");
		LocalDate dataNascimento = LocalDate.parse(dbSqlDate.toString());
		long celular = resultSet.getLong("celular");
		long telefone = resultSet.getLong("telefone");
		String email = resultSet.getString("email");
		EnumGenero genero = EnumGenero.fromInt(resultSet.getInt("genero"));

		int idEndereco = resultSet.getInt("endereco_id");
		int cep = resultSet.getInt("cep");
		String estado = resultSet.getString("estado");
		String cidade = resultSet.getString("cidade");
		String bairro = resultSet.getString("bairro");
		String rua = resultSet.getString("rua");
		String numero = resultSet.getString("numero");
		String complemento = resultSet.getString("complemento");

		int idPaciente = resultSet.getInt("paciente_id");
		float altura = resultSet.getFloat("altura");
		boolean fumante = resultSet.getBoolean("fumante");
		boolean marcaPasso = resultSet.getBoolean("marcaPasso");

		int idConvenio = resultSet.getInt("convenio_id");
		int numeroCarteirinha = resultSet.getInt("numeroCarteirinha");
		String prestadora = resultSet.getString("prestadora");
		String plano = resultSet.getString("plano");

		int idHistoricoMedico = resultSet.getInt("historicoMedico_id");
		String alergias = resultSet.getString("alergias");
		String medicamentos = resultSet.getString("medicamentos");
		String condicaoMedica = resultSet.getString("condicaoMedica");

		return new PacienteFullDTO(idPessoa, nome, cpf, rg, dataNascimento, celular, telefone, email, genero,
				idEndereco, cep, estado, cidade, bairro, rua, numero, complemento, idPaciente, altura, fumante,
				marcaPasso, idConvenio, numeroCarteirinha, prestadora, plano, idHistoricoMedico, alergias, medicamentos,
				condicaoMedica);
	}
}
