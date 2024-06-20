package model.persistence.dao.paciente;

import java.time.LocalDate;

public class PessoaPacienteDTO {
	String nome;
	String cpf;
	String rg;
	LocalDate dataNascimento;
	long celular;
	long telefone;
	String email;
	int genero;
	int endereco_id;

	public PessoaPacienteDTO(String nome, String cpf, String rg, LocalDate dataNascimento, long celular, long telefone,
			String email, int genero, int endereco_id) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
		this.endereco_id = endereco_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public int getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(int endereco_id) {
		this.endereco_id = endereco_id;
	}

	@Override
	public String toString() {
		return "PessoaDTO [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento
				+ ", celular=" + celular + ", telefone=" + telefone + ", email=" + email + ", genero=" + genero
				+ ", endereco_id=" + endereco_id + "]";
	}

}
