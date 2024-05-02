package model.entities;

public abstract class Paciente extends BaseEntity {
	float altura;
	boolean fumante;
	boolean marcaPasso;
	Convenio convenio;
	HistoricoMedico historicoMedico;
	Pessoa pessoa;
	
	public Paciente(int id, float altura, boolean fumante, boolean marcaPasso, Convenio convenio,
			HistoricoMedico historicoMedico) {
		super(id);
		this.altura = altura;
		this.fumante = fumante;
		this.marcaPasso = marcaPasso;
		this.convenio = convenio;
		this.historicoMedico = historicoMedico;
	}
}
