package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;

public class Ecocardiograma extends BaseEntity {
	int raizAorta;
	int atrioEsquerdo;
	int vdDiastolico;
	int veSistolico;
	int vePosterior;
	int septoIntraventricular;
	int fracaoEncurtamento;
	float fracaoEjecao;
	Exame exame;
}
