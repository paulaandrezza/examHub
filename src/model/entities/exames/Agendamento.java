package model.entities.exames;

import java.time.LocalDateTime;

import model.entities.BaseEntity;
import model.entities.Paciente;
import model.enums.EnumStatusAgendamento;
import model.enums.EnumTipoExame;

public class Agendamento extends BaseEntity {
	LocalDateTime dataEhorario;
	Paciente Paciente;
	String medicoSolicitante;
	EnumStatusAgendamento statusAgendamento;
	EnumTipoExame tipoExame;

	public Agendamento(int id, LocalDateTime dataEhorario, model.entities.Paciente paciente, String medicoSolicitante,
			EnumStatusAgendamento statusAgendamento, EnumTipoExame tipoExame) {
		super(id);
		this.dataEhorario = dataEhorario;
		Paciente = paciente;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = statusAgendamento;
		this.tipoExame = tipoExame;
	}

	public Agendamento(LocalDateTime dataEhorario, model.entities.Paciente paciente, String medicoSolicitante,
			EnumStatusAgendamento statusAgendamento, EnumTipoExame tipoExame) {
		this.dataEhorario = dataEhorario;
		Paciente = paciente;
		this.medicoSolicitante = medicoSolicitante;
		this.statusAgendamento = statusAgendamento;
		this.tipoExame = tipoExame;
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

	public EnumTipoExame getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(EnumTipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}

	@Override
	public String toString() {
		return "Agendamento [dataEhorario=" + dataEhorario + ", Paciente=" + Paciente + ", medicoSolicitante="
				+ medicoSolicitante + ", statusAgendamento=" + statusAgendamento + ", tipoExame=" + tipoExame + "]";
	}

}
