package model.entities.exames;

import model.entities.BaseEntity;
import model.entities.Medico;

public class Exame extends BaseEntity {
	float peso;
	Medico medicoResponsavel;
	String conclusoes;
	String detalhes;
	int diagnosticoClinico;
	
	public Exame(int id, float peso, Medico medicoResponsavel, String conclusoes, String detalhes,
			int diagnosticoClinico) {
		super(id);
		this.peso = peso;
		this.medicoResponsavel = medicoResponsavel;
		this.conclusoes = conclusoes;
		this.detalhes = detalhes;
		this.diagnosticoClinico = diagnosticoClinico;
	}
}
