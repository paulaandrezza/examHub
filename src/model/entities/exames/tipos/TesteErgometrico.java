package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;
import model.enums.Diagnostico;


public class TesteErgometrico extends BaseEntity {
	int ritmo;
	int fc;
	String detalhes;
	String conclusoes;
	Diagnostico diagnosticoClinico;
	Exame exame;
	
	public TesteErgometrico(int id, int ritmo, int fc, String detalhes, String conclusoes,
			Diagnostico diagnosticoClinico, Exame exame) {
		super(id);
		this.ritmo = ritmo;
		this.fc = fc;
		this.detalhes = detalhes;
		this.conclusoes = conclusoes;
		this.diagnosticoClinico = diagnosticoClinico;
		this.exame = exame;
	}
}
