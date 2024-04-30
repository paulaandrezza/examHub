package model.entities;

public class Endereco extends BaseEntity {
	int cep;
	String estado;
	String cidade;
	String bairro;
	String rua;
	String numero;
	String complemento;
	
	public Endereco(int id, int cep, String estado, String cidade, String bairro, String rua, String numero,
			String complemento) {
		super(id);
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro + ", rua="
				+ rua + ", numero=" + numero + ", complemento=" + complemento + ", id=" + id + "]";
	}
	
	
}
