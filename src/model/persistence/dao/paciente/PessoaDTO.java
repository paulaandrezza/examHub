package model.persistence.dao.paciente;

import java.time.LocalDate;

public class PessoaDTO {
	String nome;
	String cpf;
	LocalDate dataNascimento;
	long celular;
	long telefone;
	String email;
	int genero;
	int endereco_id;

	public PessoaDTO(String nome, String cpf, LocalDate dataNascimento, long celular, long telefone, String email,
			int genero, int endereco_id) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
		this.endereco_id = endereco_id;
	}
}
