package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Eletrocardiograma extends Exame {
	int idEletrocardiograma;
	String ritmo;
	int fc;
	float ondaP;
	int complexoQRS;
	int eixoEletrico;

	public Eletrocardiograma(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int idEletrocardiograma, String ritmo, int fc,
			float ondaP, int complexoQRS, int eixoEletrico) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		this.idEletrocardiograma = idEletrocardiograma;
		this.ritmo = ritmo;
		this.fc = fc;
		this.ondaP = ondaP;
		this.complexoQRS = complexoQRS;
		this.eixoEletrico = eixoEletrico;
	}

	@Override
	public String toString() {
		return "Eletrocardiograma [idEletrocardiograma=" + idEletrocardiograma + ", ritmo=" + ritmo + ", fc=" + fc
				+ ", ondaP=" + ondaP + ", complexoQRS=" + complexoQRS + ", eixoEletrico=" + eixoEletrico + "]\n";
	}

}
