package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Ecocardiograma extends Exame {
	int idEcocardiograma;
	int raizAorta;
	int atrioEsquerdo;
	int vdDiastolico;
	int veSistolico;
	int vePosterior;
	int septoIntraventricular;
	int fracaoEncurtamento;
	float fracaoEjecao;

	public Ecocardiograma(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int idEcocardiograma, int raizAorta,
			int atrioEsquerdo, int vdDiastolico, int veSistolico, int vePosterior, int septoIntraventricular,
			int fracaoEncurtamento, float fracaoEjecao) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		this.idEcocardiograma = idEcocardiograma;
		this.raizAorta = raizAorta;
		this.atrioEsquerdo = atrioEsquerdo;
		this.vdDiastolico = vdDiastolico;
		this.veSistolico = veSistolico;
		this.vePosterior = vePosterior;
		this.septoIntraventricular = septoIntraventricular;
		this.fracaoEncurtamento = fracaoEncurtamento;
		this.fracaoEjecao = fracaoEjecao;
	}

	@Override
	public String toString() {
		return "Ecocardiograma [idEcocardiograma=" + idEcocardiograma + ", raizAorta=" + raizAorta + ", atrioEsquerdo="
				+ atrioEsquerdo + ", vdDiastolico=" + vdDiastolico + ", veSistolico=" + veSistolico + ", vePosterior="
				+ vePosterior + ", septoIntraventricular=" + septoIntraventricular + ", fracaoEncurtamento="
				+ fracaoEncurtamento + ", fracaoEjecao=" + fracaoEjecao + "]\n";
	}

}
