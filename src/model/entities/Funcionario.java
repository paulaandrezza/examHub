package model.entities;

import model.enums.EnumTipoFuncionario;

public class Funcionario extends BaseEntity {
	String emailCorporativo;
	String senha;
	EnumTipoFuncionario tipoFuncionario;
	Pessoa pessoa;

	public Funcionario(int id, String emailCorporativo, String senha, EnumTipoFuncionario tipoFuncionario,
			Pessoa pessoa) {
		super(id);
		this.emailCorporativo = emailCorporativo;
		this.senha = senha;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
	}

	public Funcionario(int id, String emailCorporativo, EnumTipoFuncionario tipoFuncionario, Pessoa pessoa) {
		super(id);
		this.emailCorporativo = emailCorporativo;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
	}
}
