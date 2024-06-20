package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class Mapa extends Exame {
	int idMapa;
	String mediaHoras;
	String paVirgula;
	String paSono;

	public Mapa(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int idMapa, String mediaHoras,
			String paVirgula, String paSono) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		this.idMapa = idMapa;
		this.mediaHoras = mediaHoras;
		this.paVirgula = paVirgula;
		this.paSono = paSono;
	}

	@Override
	public String toString() {
		return "Mapa [idMapa=" + idMapa + ", mediaHoras=" + mediaHoras + ", paVirgula=" + paVirgula + ", paSono="
				+ paSono + "]\n";
	}

}
