package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Convenio;
import model.entities.Endereco;
import model.entities.HistoricoMedico;
import model.entities.Paciente;
import model.entities.Pessoa;
import model.exceptions.EntityNotFoundException;
import model.persistence.dao.paciente.PacienteDAO;
import model.persistence.dao.paciente.PacienteFullDTO;

public class PacienteController implements IController<PacienteFullDTO, Paciente> {
	private PacienteDAO pacienteDAO;

	public PacienteController() {
		this.pacienteDAO = new PacienteDAO();
	}

	@Override
	public int create(PacienteFullDTO dto) throws Exception {
		Paciente paciente = convertDtoToEntity(dto);
		try {
			return pacienteDAO.save(paciente);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar paciente: " + e.getMessage());
			throw e;
		}
	}

	public void delete(int paciente_id) throws SQLException, EntityNotFoundException {
		pacienteDAO.delete(paciente_id);
	}

	public void update(PacienteFullDTO pacienteFullDTO) throws SQLException, EntityNotFoundException {
		pacienteDAO.update(pacienteFullDTO);
	}

	@Override
	public List<Paciente> getAll() {
		List<PacienteFullDTO> pacientesFullDTO = pacienteDAO.getAll(null);

		return convertDtoListToEntityList(pacientesFullDTO);
	}

	@Override
	public List<Paciente> searchByField(String fieldName, Object fieldValue) throws SQLException {
		try {
			List<PacienteFullDTO> pacientesFullDTO = pacienteDAO.findByField(fieldName, fieldValue, null);
			return convertDtoListToEntityList(pacientesFullDTO);
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public Paciente convertDtoToEntity(PacienteFullDTO dto) {
		Endereco endereco = new Endereco(dto.getIdEndereco(), dto.getCep(), dto.getEstado(), dto.getCidade(),
				dto.getBairro(), dto.getRua(), dto.getNumero(), dto.getComplemento());

		Pessoa pessoa = new Pessoa(dto.getIdPessoa(), dto.getNome(), dto.getCpf(), dto.getRg(), dto.getDataNascimento(),
				dto.getCelular(), dto.getTelefone(), dto.getEmail(), dto.getGenero(), endereco);

		Convenio convenio = new Convenio(dto.getIdConvenio(), dto.getNumeroCarteirinha(), dto.getPrestadora(),
				dto.getPlano());

		HistoricoMedico historicoMedico = new HistoricoMedico(dto.getIdHistoricoMedico(), dto.getAlergias(),
				dto.getMedicamentos(), dto.getCondicaoMedica());

		Paciente paciente = new Paciente(dto.getIdPaciente(), dto.getAltura(), dto.isFumante(), dto.isMarcaPasso(),
				convenio, historicoMedico, pessoa);

		return paciente;
	}

	public List<Paciente> convertDtoListToEntityList(List<PacienteFullDTO> pacientesFullDTO) {
		List<Paciente> pacientes = new ArrayList<Paciente>();

		for (PacienteFullDTO dto : pacientesFullDTO) {
			Paciente paciente = convertDtoToEntity(dto);
			pacientes.add(paciente);
		}

		return pacientes;
	}

}
