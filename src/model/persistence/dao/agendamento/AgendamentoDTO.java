package model.persistence.dao.agendamento;

import java.time.LocalDateTime;

import model.enums.EnumStatusAgendamento;

public class AgendamentoDTO {
	private Integer id;
	private LocalDateTime dataEhorario;
	private int paciente_id;
	private String medicoSolicitante;
	private int statusAgendamento;

	public AgendamentoDTO(int id, LocalDateTime dataEhorario, int paciente_id, String medicoSolicitante,
			int statusAgendamento) {
		this.id = id;
		this.dataEhorario = dataEhorario;
		this.paciente_id = paciente_id;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = statusAgendamento;
	}

	public AgendamentoDTO(LocalDateTime dataEhorario, int paciente_id, String medicoSolicitante) {
		this.id = null;
		this.dataEhorario = dataEhorario;
		this.paciente_id = paciente_id;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = EnumStatusAgendamento.AGENDADO.getValue();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "AgendamentoDTO [id=" + id + ", dataEhorario=" + dataEhorario + ", paciente_id=" + paciente_id
				+ ", medicoSolicitante=" + medicoSolicitante + ", statusAgendamento=" + statusAgendamento + "]";
	}

}
