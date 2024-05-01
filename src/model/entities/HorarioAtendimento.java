package model.entities;

import java.time.LocalTime;

import model.enums.DiaDaSemana;

public class HorarioAtendimento extends BaseEntity {
	DiaDaSemana diaDaSemana;
	LocalTime horarioInicio;
	LocalTime horarioFim;
	
	public HorarioAtendimento(int id, DiaDaSemana diaDaSemana, LocalTime horarioInicio, LocalTime horarioFim) {
		super(id);
		this.diaDaSemana = diaDaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
	}	
}
