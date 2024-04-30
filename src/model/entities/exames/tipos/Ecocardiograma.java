package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;

public class Ecocardiograma extends BaseEntity {
	int raizAorta;
	int atrioEsquerdo;
	int vdDiastolico;
	int veSistolico;
	int vePosterior;
	int septoIntraventricular;
	int fracaoEncurtamento;
	float fracaoEjecao;
	Exame exame;
	
	public Ecocardiograma(int id, int raizAorta, int atrioEsquerdo, int vdDiastolico, int veSistolico, int vePosterior,
			int septoIntraventricular, int fracaoEncurtamento, float fracaoEjecao, Exame exame) {
		super(id);
		this.raizAorta = raizAorta;
		this.atrioEsquerdo = atrioEsquerdo;
		this.vdDiastolico = vdDiastolico;
		this.veSistolico = veSistolico;
		this.vePosterior = vePosterior;
		this.septoIntraventricular = septoIntraventricular;
		this.fracaoEncurtamento = fracaoEncurtamento;
		this.fracaoEjecao = fracaoEjecao;
		this.exame = exame;
	}
}
