package model.persistence.dao.exame;

import model.persistence.dao.agendamento.AgendamentoDTO;

public class MapaDTO extends ExameDTO {
	int id;
	String mediaHoras;
	String paVirgula;
	String paSono;
	int exame_id;

	public MapaDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes, int diagnosticoClinico,
			int agendamento_id, AgendamentoDTO agendamentoDTO, int id, String mediaHoras, String paVirgula,
			String paSono, int exame_id) {
		super(exame_id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id,
				agendamentoDTO);
		this.id = id;
		this.mediaHoras = mediaHoras;
		this.paVirgula = paVirgula;
		this.paSono = paSono;
		this.exame_id = exame_id;
	}

	public MapaDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes, int diagnosticoClinico,
			int agendamento_id, String mediaHoras, String paVirgula, String paSono) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.mediaHoras = mediaHoras;
		this.paVirgula = paVirgula;
		this.paSono = paSono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMediaHoras() {
		return mediaHoras;
	}

	public void setMediaHoras(String mediaHoras) {
		this.mediaHoras = mediaHoras;
	}

	public String getPaVirgula() {
		return paVirgula;
	}

	public void setPaVirgula(String paVirgula) {
		this.paVirgula = paVirgula;
	}

	public String getPaSono() {
		return paSono;
	}

	public void setPaSono(String paSono) {
		this.paSono = paSono;
	}

	public int getExame_id() {
		return exame_id;
	}

	public void setExame_id(int exame_id) {
		this.exame_id = exame_id;
	}

}
