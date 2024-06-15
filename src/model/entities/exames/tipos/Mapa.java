package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Mapa extends Exame {
	int id;
	String mediaHoras;
	String paVirgula;
	String paSono;
	Exame exame;

	public Mapa(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int id2, String mediaHoras, String paVirgula,
			String paSono, Exame exame) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		id = id2;
		this.mediaHoras = mediaHoras;
		this.paVirgula = paVirgula;
		this.paSono = paSono;
		this.exame = exame;
	}

}
