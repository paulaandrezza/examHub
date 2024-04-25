package model.entities;

public abstract class Paciente extends BaseEntity {
	float altura;
	boolean fumante;
	boolean marcaPasso;
	Convenio convenio;
	HistoricoMedico historicoMedico;
}
