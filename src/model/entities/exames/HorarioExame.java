package model.entities.exames;

import model.entities.BaseEntity;
import model.entities.Medico;
import model.entities.Paciente;

public class HorarioExame extends BaseEntity {

	String DataEhorario; 
	Paciente Paciente;
	Medico medicoSolicitante;

}
