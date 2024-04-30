package model.entities.exames;

import model.entities.BaseEntity;
import model.entities.Medico;
import model.entities.Paciente;

public class HorarioExame extends BaseEntity {
	String DataEhorario; 
	Paciente Paciente;
	Medico medicoSolicitante;
	
	public HorarioExame(int id, String dataEhorario, model.entities.Paciente paciente, Medico medicoSolicitante) {
		super(id);
		DataEhorario = dataEhorario;
		Paciente = paciente;
		this.medicoSolicitante = medicoSolicitante;
	}
}
