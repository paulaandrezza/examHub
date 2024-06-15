package model.persistence.dao.exame;

public class HolterDTO extends ExameDTO {
	int id;
	int arritmia;
	int isquemiaCardiaca;
	int dcIntravicular;
	int dcAtriovencular;
	boolean apneiaSono;
	int exame_id;

	public HolterDTO(int id, float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, int id2, int arritmia, int isquemiaCardiaca, int dcIntravicular,
			int dcAtriovencular, boolean apneiaSono, int exame_id) {
		super(id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		id = id2;
		this.arritmia = arritmia;
		this.isquemiaCardiaca = isquemiaCardiaca;
		this.dcIntravicular = dcIntravicular;
		this.dcAtriovencular = dcAtriovencular;
		this.apneiaSono = apneiaSono;
		this.exame_id = exame_id;
	}

	public HolterDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes, int diagnosticoClinico,
			int agendamento_id, int arritmia, int isquemiaCardiaca, int dcIntravicular, int dcAtriovencular,
			boolean apneiaSono, int exame_id) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.arritmia = arritmia;
		this.isquemiaCardiaca = isquemiaCardiaca;
		this.dcIntravicular = dcIntravicular;
		this.dcAtriovencular = dcAtriovencular;
		this.apneiaSono = apneiaSono;
		this.exame_id = exame_id;
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
