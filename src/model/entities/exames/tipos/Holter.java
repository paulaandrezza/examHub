package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Holter extends Exame {
	int idHolter;
	int arritmia;
	int isquemiaCardiaca;
	int dcIntravicular;
	int dcAtriovencular;
	boolean apneiaSono;

	public Holter(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int idHolter, int arritmia,
			int isquemiaCardiaca, int dcIntravicular, int dcAtriovencular, boolean apneiaSono) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		this.idHolter = idHolter;
		this.arritmia = arritmia;
		this.isquemiaCardiaca = isquemiaCardiaca;
		this.dcIntravicular = dcIntravicular;
		this.dcAtriovencular = dcAtriovencular;
		this.apneiaSono = apneiaSono;
	}

	@Override
	public String toString() {
		return "Holter [idHolter=" + idHolter + ", arritmia=" + arritmia + ", isquemiaCardiaca=" + isquemiaCardiaca
				+ ", dcIntravicular=" + dcIntravicular + ", dcAtriovencular=" + dcAtriovencular + ", apneiaSono="
				+ apneiaSono + "]\n";
	}

}
