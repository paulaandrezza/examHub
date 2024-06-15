package model.persistence.dao.agendamento;

import java.time.LocalDateTime;

import model.enums.EnumStatusAgendamento;

public class AgendamentoDTO {
	private Integer id;
	private LocalDateTime dataEhorario;
	private int paciente_id;
	private String medicoSolicitante;
	private int statusAgendamento;
	private int tipoExame;

	public AgendamentoDTO(Integer id, LocalDateTime dataEhorario, int paciente_id, String medicoSolicitante,
			int statusAgendamento, int tipoExame) {
		this.id = id;
		this.dataEhorario = dataEhorario;
		this.paciente_id = paciente_id;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = statusAgendamento;
		this.tipoExame = tipoExame;
	}

	public AgendamentoDTO(LocalDateTime dataEhorario, int paciente_id, String medicoSolicitante, int tipoExame) {
		this.dataEhorario = dataEhorario;
		this.paciente_id = paciente_id;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = EnumStatusAgendamento.AGENDADO.getValue();
		this.tipoExame = tipoExame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataEhorario() {
		return dataEhorario;
	}

	public void setDataEhorario(LocalDateTime dataEhorario) {
		this.dataEhorario = dataEhorario;
	}

	public int getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(int paciente_id) {
		this.paciente_id = paciente_id;
	}

	public String getMedicoSolicitante() {
		return medicoSolicitante;
	}

	public void setMedicoSolicitante(String medicoSolicitante) {
		this.medicoSolicitante = medicoSolicitante;
	}

	public int getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(int statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public int getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(int tipoExame) {
		this.tipoExame = tipoExame;
	}

	@Override
	public String toString() {
		return "AgendamentoDTO [id=" + id + ", dataEhorario=" + dataEhorario + ", paciente_id=" + paciente_id
				+ ", medicoSolicitante=" + medicoSolicitante + ", statusAgendamento=" + statusAgendamento
				+ ", tipoExame=" + tipoExame + "]";
	}

}
