package model.entities;

import java.util.Date;

import model.enums.Genero;

public class Pessoa extends BaseEntity {
	String nome;
	String cpf;
	Date dataNascimento;
	int celular;
	String email;
	Genero genero;
	Endereco endereco;
	
	public Pessoa(int id, String nome, String cpf, Date dataNascimento, int celular, String email, Genero genero,
			Endereco endereco) {
		super(id);
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.email = email;
		this.genero = genero;
		this.endereco = endereco;
	}
}
