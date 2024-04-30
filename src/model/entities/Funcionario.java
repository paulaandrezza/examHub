package model.entities;

public class Funcionario extends BaseEntity {
	String emailCorporativo;
	String senha;
	Pessoa pessoa;
	
	public Funcionario(int id, String emailCorporativo, String senha, Pessoa pessoa) {
		super(id);
		this.emailCorporativo = emailCorporativo;
		this.senha = senha;
		this.pessoa = pessoa;
	}
}
