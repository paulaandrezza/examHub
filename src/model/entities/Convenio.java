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

	public long getNumeroCarteirinha() {
		return numeroCarteirinha;
	}

	public void setNumeroCarteirinha(long numeroCarteirinha) {
		this.numeroCarteirinha = numeroCarteirinha;
	}

	public String getPrestadora() {
		return prestadora;
	}

	public void setPrestadora(String prestadora) {
		this.prestadora = prestadora;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}
}
