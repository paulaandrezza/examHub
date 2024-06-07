package model.entities.exames;

import java.time.LocalDateTime;

import model.entities.BaseEntity;
import model.entities.Paciente;
import model.enums.EnumStatusAgendamento;

public class Agendamento extends BaseEntity {
	LocalDateTime dataEhorario;
	Paciente Paciente;
	String medicoSolicitante;
	EnumStatusAgendamento statusAgendamento;

	public Agendamento(int id, LocalDateTime dataEhorario, model.entities.Paciente paciente, String medicoSolicitante,
			EnumStatusAgendamento statusAgendamento) {
		super(id);
		this.dataEhorario = dataEhorario;
		Paciente = paciente;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = statusAgendamento;
	}

	public Agendamento(LocalDateTime dataEhorario, model.entities.Paciente paciente, String medicoSolicitante,
			EnumStatusAgendamento statusAgendamento) {
		this.dataEhorario = dataEhorario;
		Paciente = paciente;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = statusAgendamento;
	}

	public LocalDateTime getDataEhorario() {
		return dataEhorario;
	}

	public void setDataEhorario(LocalDateTime dataEhorario) {
		this.dataEhorario = dataEhorario;
	}

	public Paciente getPaciente() {
		return Paciente;
	}

	public void setPaciente(Paciente paciente) {
		Paciente = paciente;
	}

	public String getMedicoSolicitante() {
		return medicoSolicitante;
	}

	public void setMedicoSolicitante(String medicoSolicitante) {
		this.medicoSolicitante = medicoSolicitante;
	}

	public EnumStatusAgendamento getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(EnumStatusAgendamento statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	@Override
	public String toString() {
		return "Agendamento [dataEhorario=" + dataEhorario + ", Paciente=" + Paciente + ", medicoSolicitante="
				+ medicoSolicitante + ", statusAgendamento=" + statusAgendamento + "]";
	}

}
