package model.entities.exames.tipos;

import model.entities.BaseEntity;
import model.entities.exames.Exame;

public class Mapa extends BaseEntity {
	String mediaHoras;
	String paVirgula;
	String paSono;
	Exame exame;
	
	public Mapa(int id, String mediaHoras, String paVirgula, String paSono, Exame exame) {
		super(id);
		this.mediaHoras = mediaHoras;
		this.paVirgula = paVirgula;
		this.paSono = paSono;
		this.exame = exame;
	}
}
