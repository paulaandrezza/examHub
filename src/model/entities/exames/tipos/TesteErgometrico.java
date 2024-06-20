package model.entities.exames.tipos;

import model.entities.Funcionario;
import model.entities.exames.Agendamento;
import model.entities.exames.Exame;
import model.enums.EnumDiagnostico;

public class TesteErgometrico extends Exame {
	int idTesteErgometrico;
	int ritmo;
	int fc;

	public TesteErgometrico(int id, float peso, Funcionario medicoResponsavel, String conclusoes, String detalhes,
			EnumDiagnostico diagnosticoClinico, Agendamento agendamento, int idTesteErgometrico, int ritmo, int fc) {
		super(id, peso, medicoResponsavel, conclusoes, detalhes, diagnosticoClinico, agendamento);
		this.idTesteErgometrico = idTesteErgometrico;
		this.ritmo = ritmo;
		this.fc = fc;
	}

	@Override
	public String toString() {
		return "TesteErgometrico [idTesteErgometrico=" + idTesteErgometrico + ", ritmo=" + ritmo + ", fc=" + fc + "]\n";
	}

}
