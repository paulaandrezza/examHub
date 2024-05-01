package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;

public class Holter extends BaseEntity {
	int arritmia;
	int isquemiaCardiaca;
	int dcIntravicular;
	int dcAtriovencular;
	boolean apneiaSono;
	Exame exame;
	
	public Holter(int id, int arritmia, int isquemiaCardiaca, int dcIntravicular, int dcAtriovencular,
			boolean apneiaSono, Exame exame) {
		super(id);
		this.arritmia = arritmia;
		this.isquemiaCardiaca = isquemiaCardiaca;
		this.dcIntravicular = dcIntravicular;
		this.dcAtriovencular = dcAtriovencular;
		this.apneiaSono = apneiaSono;
		this.exame = exame;
	}
}
