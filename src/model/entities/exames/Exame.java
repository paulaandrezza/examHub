package model.entities.exames;

import model.entities.BaseEntity;
import model.entities.Medico;

public class Exame extends BaseEntity {

	float peso;
	Medico medicoResponsavel;
	String conclusoes;
	String detalhes;
	int diagnosticoClinico;
	
}
