package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;
import model.enums.Diagnostico;


public class Holter extends BaseEntity {
	int ritmo;
	int fc;
	String detalhes;
	String conclusoes;
	Diagnostico diagnosticoClinico;
	Exame exame;
}
