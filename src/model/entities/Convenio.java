package model.entities;

public class Convenio extends BaseEntity {
	int numeroCarteirinha;
	String prestadora;
	String plano;
	
	public Convenio(int id, int numeroCarteirinha, String prestadora, String plano) {
		super(id);
		this.numeroCarteirinha = numeroCarteirinha;
		this.prestadora = prestadora;
		this.plano = plano;
	}
}
