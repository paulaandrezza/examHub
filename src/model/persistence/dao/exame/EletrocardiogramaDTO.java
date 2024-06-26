package model.persistence.dao.exame;

import model.persistence.dao.agendamento.AgendamentoDTO;

public class EletrocardiogramaDTO extends ExameDTO {
	int id;
	String ritmo;
	int fc;
	float ondaP;
	int complexoQRS;
	int eixoEletrico;
	int exame_id;

	public EletrocardiogramaDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, AgendamentoDTO agendamentoDTO, int id, String ritmo, int fc,
			float ondaP, int complexoQRS, int eixoEletrico, int exame_id) {
		super(exame_id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id,
				agendamentoDTO);
		this.id = id;
		this.ritmo = ritmo;
		this.fc = fc;
		this.ondaP = ondaP;
		this.complexoQRS = complexoQRS;
		this.eixoEletrico = eixoEletrico;
		this.exame_id = exame_id;
	}

	public EletrocardiogramaDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, String ritmo, int fc, float ondaP, int complexoQRS,
			int eixoEletrico) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.ritmo = ritmo;
		this.fc = fc;
		this.ondaP = ondaP;
		this.complexoQRS = complexoQRS;
		this.eixoEletrico = eixoEletrico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRitmo() {
		return ritmo;
	}

	public void setRitmo(String ritmo) {
		this.ritmo = ritmo;
	}

	public int getFc() {
		return fc;
	}

	public void setFc(int fc) {
		this.fc = fc;
	}

	public float getOndaP() {
		return ondaP;
	}

	public void setOndaP(float ondaP) {
		this.ondaP = ondaP;
	}

	public int getComplexoQRS() {
		return complexoQRS;
	}

	public void setComplexoQRS(int complexoQRS) {
		this.complexoQRS = complexoQRS;
	}

	public int getEixoEletrico() {
		return eixoEletrico;
	}

	public void setEixoEletrico(int eixoEletrico) {
		this.eixoEletrico = eixoEletrico;
	}

	public int getExame_id() {
		return exame_id;
	}

	public void setExame_id(int exame_id) {
		this.exame_id = exame_id;
	}

}
