package model.entities;

import model.enums.EnumTipoFuncionario;

public class Funcionario extends BaseEntity {
	String emailCorporativo;
	String senha;
	EnumTipoFuncionario tipoFuncionario;
	Pessoa pessoa;

	public Funcionario(int id, String emailCorporativo, String senha, Pessoa pessoa,
			EnumTipoFuncionario tipoFuncionario) {
		super(id);
		this.emailCorporativo = emailCorporativo;
		this.senha = senha;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa = pessoa;
	}
}
