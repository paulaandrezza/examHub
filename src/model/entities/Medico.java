package model.entities;

import java.util.List;

import model.enums.EspecialidadeMedica;

public class Medico extends BaseEntity {
	Funcionario funcionario;
	EspecialidadeMedica especidalide;
	List<HorarioAtendimento> horariosAtendimento;
}
