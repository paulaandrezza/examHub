package model.persistence.dao.exame;

public class ExameDTO {
	int id;
	float peso;
	int medicoResponsavel_id;
	String conclusoes;
	String detalhes;
	int diagnosticoClinico;
	int agendamento_id;

	public ExameDTO(int id, float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id) {
		super();
		this.id = id;
		this.peso = peso;
		this.medicoResponsavel_id = medicoResponsavel_id;
		this.conclusoes = conclusoes;
		this.detalhes = detalhes;
		this.diagnosticoClinico = diagnosticoClinico;
		this.agendamento_id = agendamento_id;
	}

	public ExameDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes, int diagnosticoClinico,
			int agendamento_id) {
		this.peso = peso;
		this.medicoResponsavel_id = medicoResponsavel_id;
		this.conclusoes = conclusoes;
		this.detalhes = detalhes;
		this.diagnosticoClinico = diagnosticoClinico;
		this.agendamento_id = agendamento_id;
	}

	public ExameDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getMedicoResponsavel_id() {
		return medicoResponsavel_id;
	}

	public void setMedicoResponsavel_id(int medicoResponsavel_id) {
		this.medicoResponsavel_id = medicoResponsavel_id;
	}

	public String getConclusoes() {
		return conclusoes;
	}

	public void setConclusoes(String conclusoes) {
		this.conclusoes = conclusoes;
	}

	public String getDetalhes() {
		return detalhes;
	}

	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}

	public int getDiagnosticoClinico() {
		return diagnosticoClinico;
	}

	public void setDiagnosticoClinico(int diagnosticoClinico) {
		this.diagnosticoClinico = diagnosticoClinico;
	}

	public int getAgendamento_id() {
		return agendamento_id;
	}

	public void setAgendamento_id(int agendamento_id) {
		this.agendamento_id = agendamento_id;
	}

}
