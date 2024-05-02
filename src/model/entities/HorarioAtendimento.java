package model.entities;

import java.time.LocalTime;

import model.enums.EnumDiaDaSemana;

public class HorarioAtendimento extends BaseEntity {
	EnumDiaDaSemana diaDaSemana;
	LocalTime horarioInicio;
	LocalTime horarioFim;
	Funcionario funcionario;

	public HorarioAtendimento(int id, EnumDiaDaSemana diaDaSemana, LocalTime horarioInicio, LocalTime horarioFim,
			Funcionario funcionario) {
		super(id);
		this.diaDaSemana = diaDaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.funcionario = funcionario;
	}

	public HorarioAtendimento(EnumDiaDaSemana diaDaSemana, LocalTime horarioInicio, LocalTime horarioFim,
			Funcionario funcionario) {
		this.diaDaSemana = diaDaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.funcionario = funcionario;
	}

}
