package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;

public class Eletrocardiograma extends BaseEntity {
	String ritmo;
	int fc;
	float ondaP;
	int complexoQRS;
	int eixoEletrico;
	Exame exame;
	
	public Eletrocardiograma(int id, String ritmo, int fc, float ondaP, int complexoQRS, int eixoEletrico,
			Exame exame) {
		super(id);
		this.ritmo = ritmo;
		this.fc = fc;
		this.ondaP = ondaP;
		this.complexoQRS = complexoQRS;
		this.eixoEletrico = eixoEletrico;
		this.exame = exame;
	}
}
