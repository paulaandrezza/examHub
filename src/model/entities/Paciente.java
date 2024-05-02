package model.entities;

public class Paciente extends BaseEntity {
	float altura;
	boolean fumante;
	boolean marcaPasso;
	Convenio convenio;
	HistoricoMedico historicoMedico;
	Pessoa pessoa;
	
	public Paciente(int id, float altura, boolean fumante, boolean marcaPasso, Convenio convenio,
			HistoricoMedico historicoMedico, Pessoa pessoa) {
		super(id);
		this.altura = altura;
		this.fumante = fumante;
		this.marcaPasso = marcaPasso;
		this.convenio = convenio;
		this.historicoMedico = historicoMedico;
		this.pessoa = pessoa;
	}
	
	public Paciente(float altura, boolean fumante, boolean marcaPasso, Convenio convenio,
			HistoricoMedico historicoMedico, Pessoa pessoa) {
		this.altura = altura;
		this.fumante = fumante;
		this.marcaPasso = marcaPasso;
		this.convenio = convenio;
		this.historicoMedico = historicoMedico;
		this.pessoa = pessoa;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public boolean isFumante() {
		return fumante;
	}

	public void setFumante(boolean fumante) {
		this.fumante = fumante;
	}

	public boolean isMarcaPasso() {
		return marcaPasso;
	}

	public void setMarcaPasso(boolean marcaPasso) {
		this.marcaPasso = marcaPasso;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public HistoricoMedico getHistoricoMedico() {
		return historicoMedico;
	}

	public void setHistoricoMedico(HistoricoMedico historicoMedico) {
		this.historicoMedico = historicoMedico;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
}
