package model.entities.external;

import com.google.gson.annotations.SerializedName;

public class Address {
	@SerializedName("cep")
	private final String cep;

	@SerializedName("logradouro")
	private final String logradouro;

	@SerializedName("bairro")
	private final String bairro;

	@SerializedName("localidade")
	private final String cidade;

	@SerializedName("uf")
	private final String estado;

	public Address(String cep, String logradouro, String complemento, String bairro, String cidade, String estado) {
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getCep() {
		return cep != null && !cep.isEmpty() ? cep : "Not available";
	}

	public String getLogradouro() {
		return logradouro != null && !logradouro.isEmpty() ? logradouro : "Not available";
	}

	public String getBairro() {
		return bairro != null && !bairro.isEmpty() ? bairro : "Not available";
	}

	public String getCidade() {
		return cidade != null && !cidade.isEmpty() ? cidade : "Not available";
	}

	public String getEstado() {
		return estado != null && !estado.isEmpty() ? estado : "Not available";
	}
}
