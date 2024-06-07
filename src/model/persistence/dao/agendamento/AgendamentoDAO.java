package model.persistence.dao.agendamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import model.persistence.dao.GenericDAO;
import model.persistence.dao.interfaces.ICommonDAO;

public class AgendamentoDAO extends GenericDAO<AgendamentoDTO> implements ICommonDAO<AgendamentoDTO> {

	public AgendamentoDAO() {
		super("agendamento");
	}

	@Override
	public int save(AgendamentoDTO agendamentoDTO) throws SQLException {
		try {
			return super.save(agendamentoDTO, "agendamento");
		} catch (SQLException e) {
			throw new SQLException("Erro ao salvar agendamento: " + e.getMessage());
		}
	}

	@Override
	public AgendamentoDTO convertResultSetToEntityDTO(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		Object dbSqlDate = resultSet.getObject("dataEhorario");
		LocalDateTime dataEhorario = LocalDateTime.parse(dbSqlDate.toString());
		int paciente_id = resultSet.getInt("paciente_id");
		String medicoSolicitante = resultSet.getString("medicoSolicitante");
		int statusAgendamento = resultSet.getInt("statusAgendamento");

		return new AgendamentoDTO(id, dataEhorario, paciente_id, medicoSolicitante, statusAgendamento);
	}

	@Override
	public void update(int id, String[] params) {
		// TODO Auto-generated method stub

	}

}
