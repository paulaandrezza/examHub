package model.persistence.dao.exame;

import model.persistence.dao.agendamento.AgendamentoDTO;

public class HolterDTO extends ExameDTO {
	int id;
	int arritmia;
	int isquemiaCardiaca;
	int dcIntravicular;
	int dcAtriovencular;
	boolean apneiaSono;
	int exame_id;

	public HolterDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes, int diagnosticoClinico,
			int agendamento_id, AgendamentoDTO agendamentoDTO, int id, int arritmia, int isquemiaCardiaca,
			int dcIntravicular, int dcAtriovencular, boolean apneiaSono, int exame_id) {
		super(exame_id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id,
				agendamentoDTO);
		this.id = id;
		this.arritmia = arritmia;
		this.isquemiaCardiaca = isquemiaCardiaca;
		this.dcIntravicular = dcIntravicular;
		this.dcAtriovencular = dcAtriovencular;
		this.apneiaSono = apneiaSono;
		this.exame_id = exame_id;
	}

	public HolterDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes, int diagnosticoClinico,
			int agendamento_id, int arritmia, int isquemiaCardiaca, int dcIntravicular, int dcAtriovencular,
			boolean apneiaSono) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.arritmia = arritmia;
		this.isquemiaCardiaca = isquemiaCardiaca;
		this.dcIntravicular = dcIntravicular;
		this.dcAtriovencular = dcAtriovencular;
		this.apneiaSono = apneiaSono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArritmia() {
		return arritmia;
	}

	public void setArritmia(int arritmia) {
		this.arritmia = arritmia;
	}

	public int getIsquemiaCardiaca() {
		return isquemiaCardiaca;
	}

	public void setIsquemiaCardiaca(int isquemiaCardiaca) {
		this.isquemiaCardiaca = isquemiaCardiaca;
	}

	public int getDcIntravicular() {
		return dcIntravicular;
	}

	public void setDcIntravicular(int dcIntravicular) {
		this.dcIntravicular = dcIntravicular;
	}

	public int getDcAtriovencular() {
		return dcAtriovencular;
	}

	public void setDcAtriovencular(int dcAtriovencular) {
		this.dcAtriovencular = dcAtriovencular;
	}

	public boolean isApneiaSono() {
		return apneiaSono;
	}

	public void setApneiaSono(boolean apneiaSono) {
		this.apneiaSono = apneiaSono;
	}

	public int getExame_id() {
		return exame_id;
	}

	public void setExame_id(int exame_id) {
		this.exame_id = exame_id;
	}

}
