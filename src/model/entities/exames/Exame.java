package model.entities.exames;

import model.entities.BaseEntity;
import model.entities.Funcionario;
import model.enums.EnumDiagnostico;

public abstract class Exame extends BaseEntity {
	float peso;
	Funcionario medicoResponsavel;
	String conclusoes;
	String detalhes;
	EnumDiagnostico diagnosticoClinico;
	Agendamento agendamento;

	public Exame(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento) {
		super(id);
		this.peso = peso;
		this.medicoResponsavel = medicoResponsavel;
		this.conclusoes = conclusoes;
		this.detalhes = detalhes;
		this.diagnosticoClinico = diagnosticoClinico;
		this.agendamento = agendamento;
	}

	public Exame(float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento) {
		this.peso = peso;
		this.medicoResponsavel = medicoResponsavel;
		this.conclusoes = conclusoes;
		this.detalhes = detalhes;
		this.diagnosticoClinico = diagnosticoClinico;
		this.agendamento = agendamento;
	}

}
