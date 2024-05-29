package model.persistence.dao.auth;

public class FuncionarioDTO {
	int id;
	String emailCorporativo;
	String senha;
	int tipoFuncionario;
	int pessoa_id;

	public FuncionarioDTO(int id, String emailCorporativo, String senha, int tipoFuncionario, int pessoa_id) {
		this.id = id;
		this.emailCorporativo = emailCorporativo;
		this.senha = senha;
		this.tipoFuncionario = tipoFuncionario;
		this.pessoa_id = pessoa_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailCorporativo() {
		return emailCorporativo;
	}

	public void setEmailCorporativo(String emailCorporativo) {
		this.emailCorporativo = emailCorporativo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(int tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public int getPessoa_id() {
		return pessoa_id;
	}

	public void setPessoa_id(int pessoa_id) {
		this.pessoa_id = pessoa_id;
	}

	@Override
	public String toString() {
		return "FuncionarioDTO [id=" + id + ", emailCorporativo=" + emailCorporativo + ", senha=" + senha
				+ ", tipoFuncionario=" + tipoFuncionario + ", pessoa_id=" + pessoa_id + "]";
	}

}
