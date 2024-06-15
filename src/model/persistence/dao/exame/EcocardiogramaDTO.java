package model.persistence.dao.exame;

public class EcocardiogramaDTO extends ExameDTO {
	int id;
	int raizAorta;
	int atrioEsquerdo;
	int vdDiastolico;
	int veSistolico;
	int vePosterior;
	int septoIntraventricular;
	int fracaoEncurtamento;
	float fracaoEjecao;
	int exame_id;

	public EcocardiogramaDTO(int id, float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, int id2, int raizAorta, int atrioEsquerdo, int vdDiastolico,
			int veSistolico, int vePosterior, int septoIntraventricular, int fracaoEncurtamento, float fracaoEjecao,
			int exame_id) {
		super(id, peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		id = id2;
		this.raizAorta = raizAorta;
		this.atrioEsquerdo = atrioEsquerdo;
		this.vdDiastolico = vdDiastolico;
		this.veSistolico = veSistolico;
		this.vePosterior = vePosterior;
		this.septoIntraventricular = septoIntraventricular;
		this.fracaoEncurtamento = fracaoEncurtamento;
		this.fracaoEjecao = fracaoEjecao;
		this.exame_id = exame_id;
	}

	public EcocardiogramaDTO(float peso, int medicoResponsavel_id, String conclusoes, String detalhes,
			int diagnosticoClinico, int agendamento_id, int raizAorta, int atrioEsquerdo, int vdDiastolico,
			int veSistolico, int vePosterior, int septoIntraventricular, int fracaoEncurtamento, float fracaoEjecao) {
		super(peso, medicoResponsavel_id, conclusoes, detalhes, diagnosticoClinico, agendamento_id);
		this.raizAorta = raizAorta;
		this.atrioEsquerdo = atrioEsquerdo;
		this.vdDiastolico = vdDiastolico;
		this.veSistolico = veSistolico;
		this.vePosterior = vePosterior;
		this.septoIntraventricular = septoIntraventricular;
		this.fracaoEncurtamento = fracaoEncurtamento;
		this.fracaoEjecao = fracaoEjecao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRaizAorta() {
		return raizAorta;
	}

	public void setRaizAorta(int raizAorta) {
		this.raizAorta = raizAorta;
	}

	public int getAtrioEsquerdo() {
		return atrioEsquerdo;
	}

	public void setAtrioEsquerdo(int atrioEsquerdo) {
		this.atrioEsquerdo = atrioEsquerdo;
	}

	public int getVdDiastolico() {
		return vdDiastolico;
	}

	public void setVdDiastolico(int vdDiastolico) {
		this.vdDiastolico = vdDiastolico;
	}

	public int getVeSistolico() {
		return veSistolico;
	}

	public void setVeSistolico(int veSistolico) {
		this.veSistolico = veSistolico;
	}

	public int getVePosterior() {
		return vePosterior;
	}

	public void setVePosterior(int vePosterior) {
		this.vePosterior = vePosterior;
	}

	public int getSeptoIntraventricular() {
		return septoIntraventricular;
	}

	public void setSeptoIntraventricular(int septoIntraventricular) {
		this.septoIntraventricular = septoIntraventricular;
	}

	public int getFracaoEncurtamento() {
		return fracaoEncurtamento;
	}

	public void setFracaoEncurtamento(int fracaoEncurtamento) {
		this.fracaoEncurtamento = fracaoEncurtamento;
	}

	public float getFracaoEjecao() {
		return fracaoEjecao;
	}

	public void setFracaoEjecao(float fracaoEjecao) {
		this.fracaoEjecao = fracaoEjecao;
	}

	public int getExame_id() {
		return exame_id;
	}

	public void setExame_id(int exame_id) {
		this.exame_id = exame_id;
	}

}
