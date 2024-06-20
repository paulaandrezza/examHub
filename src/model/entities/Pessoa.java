package model.entities;

import java.time.LocalDate;

import model.enums.EnumGenero;

public class Pessoa extends BaseEntity {
	String nome;
	String cpf;
	String rg;
	LocalDate dataNascimento;
	long celular;
	long telefone;
	String email;
	EnumGenero genero;
	Endereco endereco;

	public Pessoa(int id, String nome, String cpf, String rg, LocalDate dataNascimento, long celular, long telefone,
			String email, EnumGenero genero, Endereco endereco) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
		this.endereco = endereco;
	}

	public Pessoa(int id, String nome, String cpf, String rg, LocalDate dataNascimento, long celular, long telefone,
			String email, EnumGenero genero) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
	}

	public Pessoa(String nome, String cpf, String rg, LocalDate dataNascimento, long celular, long telefone,
			String email, EnumGenero genero, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento
				+ ", celular=" + celular + ", telefone=" + telefone + ", email=" + email + ", genero=" + genero
				+ ", endereco=" + endereco + "]";
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

	public EnumGenero getGenero() {
		return genero;
	}

	public void setGenero(EnumGenero genero) {
		this.genero = genero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
