package model.entities;

public class Convenio extends BaseEntity {
	long numeroCarteirinha;
	String prestadora;
	String plano;
	
	public Convenio(int id, long numeroCarteirinha, String prestadora, String plano) {
		super(id);
		this.numeroCarteirinha = numeroCarteirinha;
		this.prestadora = prestadora;
		this.plano = plano;
	}
	
	public Convenio(long numeroCarteirinha, String prestadora, String plano) {
		this.numeroCarteirinha = numeroCarteirinha;
		this.prestadora = prestadora;
		this.plano = plano;
	}
}
