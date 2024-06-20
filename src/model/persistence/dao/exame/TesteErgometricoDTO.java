package model.persistence.dao.exame;

import model.persistence.dao.agendamento.AgendamentoDTO;

public class TesteErgometricoDTO extends ExameDTO {
	int id;
	int ritmo;
	int fc;
	int exame_id;

	public TesteErgometricoDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, AgendamentoDTO agendamentoDTO, int id, int ritmo, int fc,
			int exame_id) {
		super(exame_id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id,
				agendamentoDTO);
		this.id = id;
		this.ritmo = ritmo;
		this.fc = fc;
		this.exame_id = exame_id;
	}

	public TesteErgometricoDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, int ritmo, int fc) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.ritmo = ritmo;
		this.fc = fc;
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
