package model.entities;

import java.time.LocalTime;

import model.enums.DiaDaSemana;

public class HorarioAtendimento extends BaseEntity {
	DiaDaSemana diaDaSemana;
	LocalTime horarioInicio;
	LocalTime horarioFim;
}
