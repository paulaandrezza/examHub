package model.entities;

import java.time.LocalTime;

import model.enums.EnumDiaDaSemana;

public class HorarioAtendimento extends BaseEntity {
	EnumDiaDaSemana diaDaSemana;
	LocalTime horarioInicio;
	LocalTime horarioFim;
	
	public HorarioAtendimento(int id, EnumDiaDaSemana diaDaSemana, LocalTime horarioInicio, LocalTime horarioFim) {
		super(id);
		this.diaDaSemana = diaDaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}	
}
