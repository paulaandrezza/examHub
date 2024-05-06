package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Convenio;
import model.entities.Endereco;
import model.entities.HistoricoMedico;
import model.entities.Paciente;
import model.entities.Pessoa;
import model.persistence.dao.paciente.PacienteDAO;
import model.persistence.dao.paciente.PacienteFullDTO;

public class PacienteController implements IController<PacienteFullDTO, Paciente> {
	private PacienteDAO pacienteDao;

	public PacienteController() {
		this.pacienteDao = new PacienteDAO();
	}

	@Override
	public int create(PacienteFullDTO dto) {
		Paciente paciente = convertDtoToEntity(dto);
		try {
			return pacienteDao.save(paciente);
		} catch (Exception e) {
			System.out.println("Erro ao adicionar paciente: " + e.getMessage());
			throw e;
		}
	}

	@Override
	public void delete(int id) {
		try {
			pacienteDao.delete(id);
			System.out.println("Entity deleted successfully.");
		} catch (SQLException e) {
			System.err.println("Error during entity deletion: " + e.getMessage());
		}
	}

	@Override
	public List<Paciente> getAll() {
		List<PacienteFullDTO> pacientesFullDTO = pacienteDao.getAll();

		return convertDtoListToEntityList(pacientesFullDTO);
	}

	@Override
	public List<Paciente> searchByField(String fieldName, Object fieldValue) {
		try {
			List<PacienteFullDTO> pacientesFullDTO = pacienteDao.findByField(fieldName, fieldValue);
			return convertDtoListToEntityList(pacientesFullDTO);
		} catch (SQLException e) {
			System.err.println("Erro ao buscar pacientes: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Paciente convertDtoToEntity(PacienteFullDTO dto) {
		Endereco endereco = new Endereco(dto.getCep(), dto.getEstado(), dto.getCidade(), dto.getBairro(), dto.getRua(),
				dto.getNumero(), dto.getComplemento());

		Pessoa pessoa = new Pessoa(dto.getNome(), dto.getCpf(), dto.getDataNascimento(), dto.getCelular(),
				dto.getTelefone(), dto.getEmail(), dto.getGenero(), endereco);

		Convenio convenio = new Convenio(dto.getNumeroCarteirinha(), dto.getPrestadora(), dto.getPlano());

		HistoricoMedico historicoMedico = new HistoricoMedico(dto.getAlergias(), dto.getMedicamentos(),
				dto.getCondicaoMedica());

		Paciente paciente = new Paciente(dto.getAltura(), dto.isFumante(), dto.isMarcaPasso(), convenio,
				historicoMedico, pessoa);

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
