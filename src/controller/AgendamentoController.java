package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Paciente;
import model.entities.exames.Agendamento;
import model.enums.EnumStatusAgendamento;
import model.enums.EnumTipoExame;
import model.exceptions.EntityNotFoundException;
import model.persistence.dao.agendamento.AgendamentoDAO;
import model.persistence.dao.agendamento.AgendamentoDTO;

public class AgendamentoController implements IController<AgendamentoDTO, Agendamento> {
	private AgendamentoDAO agendamentoDAO;
	private PacienteController pacienteController;

	public AgendamentoController() {
		this.agendamentoDAO = new AgendamentoDAO();
		this.pacienteController = new PacienteController();
	}

	@Override
	public int create(AgendamentoDTO dto) throws Exception {
		try {
			return agendamentoDAO.save(dto);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public List<Agendamento> searchByField(String fieldName, Object fieldValue)
			throws SQLException, EntityNotFoundException {
		try {
			List<AgendamentoDTO> agendamentoDTO = agendamentoDAO.findByField(fieldName, fieldValue);
			return convertDtoListToEntityList(agendamentoDTO);
		} catch (SQLException e) {
			System.err.println("Erro ao buscar agendamentos: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Agendamento getById(int id) throws SQLException, EntityNotFoundException {
		return convertDtoToEntity(agendamentoDAO.getById(id));
	}

	@Override
	public List<Agendamento> getAll() throws SQLException, EntityNotFoundException {
		List<AgendamentoDTO> agendamentoDTO = agendamentoDAO.getAll();

		return convertDtoListToEntityList(agendamentoDTO);
	}

	@Override
	public Agendamento convertDtoToEntity(AgendamentoDTO dto) throws SQLException, EntityNotFoundException {
		Paciente paciente = null;
		List<Paciente> pacientes = pacienteController.searchByField("paciente_id", dto.getPaciente_id());
		if (!pacientes.isEmpty()) {
			paciente = pacientes.get(0);
			return new Agendamento(dto.getDataEhorario(), paciente, dto.getMedicoSolicitante(),
					EnumStatusAgendamento.fromInt(dto.getStatusAgendamento()),
					EnumTipoExame.fromInt(dto.getTipoExame()));
		}

		throw new EntityNotFoundException(dto.getId(), "paciente");
	}

	@Override
	public List<Agendamento> convertDtoListToEntityList(List<AgendamentoDTO> agendamentosDTO)
			throws SQLException, EntityNotFoundException {
		List<Agendamento> agendamentos = new ArrayList<Agendamento>();

		for (AgendamentoDTO dto : agendamentosDTO) {
			Agendamento agendamento = convertDtoToEntity(dto);
			agendamentos.add(agendamento);
		}

		return agendamentos;
	}

	// TODO: Cancelar agendamento
}
