package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class TesteErgometrico extends Exame {
	int id;
	int ritmo;
	int fc;
	Exame exame;

	public TesteErgometrico(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int id2, int ritmo, int fc, Exame exame) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		id = id2;
		this.ritmo = ritmo;
		this.fc = fc;
		this.exame = exame;
	}

}
