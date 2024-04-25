package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;

public class Eletrocardiograma extends BaseEntity {
	String ritmo;
	int fc;
	Double ondaP;
	int complexoQRS;
	int eixoEletrico;
	Exame exame;
}
