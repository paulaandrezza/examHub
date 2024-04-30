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
}
