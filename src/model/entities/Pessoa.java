package model.entities;

import java.util.Date;

import model.enums.Genero;

public class Pessoa extends BaseEntity {
	String nome;
	String cpf;
	Date dataNascimento;
	long celular;
	long telefone;
	String email;
	Genero genero;
	Endereco endereco;
}
