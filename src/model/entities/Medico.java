package model.entities;

import java.util.List;

import model.enums.EspecialidadeMedica;

public class Medico extends BaseEntity {
	Funcionario funcionario;
	EspecialidadeMedica especidalide;
	List<HorarioAtendimento> horariosAtendimento;
	
	public Medico(int id, Funcionario funcionario, EspecialidadeMedica especidalide,
			List<HorarioAtendimento> horariosAtendimento) {
		super(id);
		this.funcionario = funcionario;
		this.especidalide = especidalide;
		this.horariosAtendimento = horariosAtendimento;
	}
}
