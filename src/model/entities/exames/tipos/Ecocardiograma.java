package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Ecocardiograma extends Exame {
	int id;
	int raizAorta;
	int atrioEsquerdo;
	int vdDiastolico;
	int veSistolico;
	int vePosterior;
	int septoIntraventricular;
	int fracaoEncurtamento;
	float fracaoEjecao;
	Exame exame;

	public Ecocardiograma(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int id2, int raizAorta, int atrioEsquerdo,
			int vdDiastolico, int veSistolico, int vePosterior, int septoIntraventricular, int fracaoEncurtamento,
			float fracaoEjecao, Exame exame) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		id = id2;
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
