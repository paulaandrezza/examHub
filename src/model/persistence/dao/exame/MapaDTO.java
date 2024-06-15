package model.persistence.dao.exame;

public class MapaDTO extends ExameDTO {
	int id;
	String mediaHoras;
	String paVirgula;
	String paSono;
	int exame_id;

	public MapaDTO(int id, float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, int id2, String mediaHoras, String paVirgula, String paSono,
			int exame_id) {
		super(id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		id = id2;
		this.mediaHoras = mediaHoras;
		this.paVirgula = paVirgula;
		this.paSono = paSono;
		this.exame_id = exame_id;
	}

	public MapaDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes, int diagnosticoClinico,
			int agendamento_id, String mediaHoras, String paVirgula, String paSono, int exame_id) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.mediaHoras = mediaHoras;
		this.paVirgula = paVirgula;
		this.paSono = paSono;
		this.exame_id = exame_id;
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
