package model.entities.exames;

import java.time.LocalDateTime;

import model.entities.BaseEntity;
import model.entities.Paciente;

public class HorarioExame extends BaseEntity {
	LocalDateTime DataEhorario;
	Paciente Paciente;
	String medicoSolicitante;

	public HorarioExame(int id, LocalDateTime dataEhorario, model.entities.Paciente paciente,
			String medicoSolicitante) {
		super(id);
		DataEhorario = dataEhorario;
		Paciente = paciente;
		this.medicoSolicitante = medicoSolicitante;
	}

	public HorarioExame(LocalDateTime dataEhorario, model.entities.Paciente paciente, String medicoSolicitante) {
		DataEhorario = dataEhorario;
		Paciente = paciente;
		this.medicoSolicitante = medicoSolicitante;
	}

}
