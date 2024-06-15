package model.persistence.dao.exame;

public class TesteErgometricoDTO extends ExameDTO {
	int id;
	int ritmo;
	int fc;
	int exame_id;

	public TesteErgometricoDTO(int id, float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, int id2, int ritmo, int fc, int exame_id) {
		super(id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		id = id2;
		this.ritmo = ritmo;
		this.fc = fc;
		this.exame_id = exame_id;
	}

	public TesteErgometricoDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, int ritmo, int fc, int exame_id) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.ritmo = ritmo;
		this.fc = fc;
		this.exame_id = exame_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRitmo() {
		return ritmo;
	}

	public void setRitmo(int ritmo) {
		this.ritmo = ritmo;
	}

	public int getFc() {
		return fc;
	}

	public void setFc(int fc) {
		this.fc = fc;
	}

	public int getExame_id() {
		return exame_id;
	}

	public void setExame_id(int exame_id) {
		this.exame_id = exame_id;
	}

}
