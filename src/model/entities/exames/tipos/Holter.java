package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Holter extends Exame {
	int id;
	int arritmia;
	int isquemiaCardiaca;
	int dcIntravicular;
	int dcAtriovencular;
	boolean apneiaSono;
	Exame exame;

	public Holter(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int id2, int arritmia, int isquemiaCardiaca,
			int dcIntravicular, int dcAtriovencular, boolean apneiaSono, Exame exame) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		id = id2;
		this.arritmia = arritmia;
		this.isquemiaCardiaca = isquemiaCardiaca;
		this.dcIntravicular = dcIntravicular;
		this.dcAtriovencular = dcAtriovencular;
		this.apneiaSono = apneiaSono;
		this.exame = exame;
	}

}
