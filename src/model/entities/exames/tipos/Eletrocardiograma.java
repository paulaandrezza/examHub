package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Eletrocardiograma extends Exame {
	int id;
	String ritmo;
	int fc;
	float ondaP;
	int complexoQRS;
	int eixoEletrico;
	Exame exame;

	public Eletrocardiograma(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int id2, String ritmo, int fc, float ondaP,
			int complexoQRS, int eixoEletrico, Exame exame) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		id = id2;
		this.ritmo = ritmo;
		this.fc = fc;
		this.ondaP = ondaP;
		this.complexoQRS = complexoQRS;
		this.eixoEletrico = eixoEletrico;
		this.exame = exame;
	}

}
