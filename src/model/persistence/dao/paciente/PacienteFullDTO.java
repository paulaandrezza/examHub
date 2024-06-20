package model.persistence.dao.paciente;

import java.time.LocalDate;

import model.enums.EnumGenero;

public class PacienteFullDTO {
	private int idPessoa;
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	private long celular;
	private long telefone;
	private String email;
	private EnumGenero genero;

	private int idEndereco;
	private int cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;

	private int idPaciente;
	private float altura;
	private boolean fumante;
	private boolean marcaPasso;

	private int idConvenio;
	private int numeroCarteirinha;
	private String prestadora;
	private String plano;

	private int idHistoricoMedico;
	private String alergias;
	private String medicamentos;
	private String condicaoMedica;

	public PacienteFullDTO(int idPessoa, String nome, String cpf, String rg, LocalDate dataNascimento, long celular,
			long telefone, String email, EnumGenero genero, int idEndereco, int cep, String estado, String cidade,
			String bairro, String rua, String numero, String complemento, int idPaciente, float altura, boolean fumante,
			boolean marcaPasso, int idConvenio, int numeroCarteirinha, String prestadora, String plano,
			int idHistoricoMedico, String alergias, String medicamentos, String condicaoMedica) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
		this.idEndereco = idEndereco;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.idPaciente = idPaciente;
		this.altura = altura;
		this.fumante = fumante;
		this.marcaPasso = marcaPasso;
		this.idConvenio = idConvenio;
		this.numeroCarteirinha = numeroCarteirinha;
		this.prestadora = prestadora;
		this.plano = plano;
		this.idHistoricoMedico = idHistoricoMedico;
		this.alergias = alergias;
		this.medicamentos = medicamentos;
		this.condicaoMedica = condicaoMedica;
	}

	public PacienteFullDTO(String nome, String cpf, String rg, LocalDate dataNascimento, long celular, long telefone,
			String email, EnumGenero genero, int cep, String estado, String cidade, String bairro, String rua,
			String numero, String complemento, float altura, boolean fumante, boolean marcaPasso, int numeroCarteirinha,
			String prestadora, String plano, String alergias, String medicamentos, String condicaoMedica) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.celular = celular;
		this.telefone = telefone;
		this.email = email;
		this.genero = genero;
		this.cep = cep;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.altura = altura;
		this.fumante = fumante;
		this.marcaPasso = marcaPasso;
		this.numeroCarteirinha = numeroCarteirinha;
		this.prestadora = prestadora;
		this.plano = plano;
		this.alergias = alergias;
		this.medicamentos = medicamentos;
		this.condicaoMedica = condicaoMedica;
	}

	public PacienteFullDTO() {
		super();
	}

	@Override
	public String toString() {
		return "PacienteFullDTO [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", celular=" + celular + ", telefone=" + telefone + ", email="
				+ email + ", genero=" + genero + ", idEndereco=" + idEndereco + ", cep=" + cep + ", estado=" + estado
				+ ", cidade=" + cidade + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + ", complemento="
				+ complemento + ", idPaciente=" + idPaciente + ", altura=" + altura + ", fumante=" + fumante
				+ ", marcaPasso=" + marcaPasso + ", idConvenio=" + idConvenio + ", numeroCarteirinha="
				+ numeroCarteirinha + ", prestadora=" + prestadora + ", plano=" + plano + ", idHistoricoMedico="
				+ idHistoricoMedico + ", alergias=" + alergias + ", medicamentos=" + medicamentos + ", condicaoMedica="
				+ condicaoMedica + "]";
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
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

	public int getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public boolean isFumante() {
		return fumante;
	}

	public void setFumante(boolean fumante) {
		this.fumante = fumante;
	}

	public boolean isMarcaPasso() {
		return marcaPasso;
	}

	public void setMarcaPasso(boolean marcaPasso) {
		this.marcaPasso = marcaPasso;
	}

	public int getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(int idConvenio) {
		this.idConvenio = idConvenio;
	}

	public int getNumeroCarteirinha() {
		return numeroCarteirinha;
	}

	public void setNumeroCarteirinha(int numeroCarteirinha) {
		this.numeroCarteirinha = numeroCarteirinha;
	}

	public String getPrestadora() {
		return prestadora;
	}

	public void setPrestadora(String prestadora) {
		this.prestadora = prestadora;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public int getIdHistoricoMedico() {
		return idHistoricoMedico;
	}

	public void setIdHistoricoMedico(int idHistoricoMedico) {
		this.idHistoricoMedico = idHistoricoMedico;
	}

	public String getAlergias() {
		return alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public String getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getCondicaoMedica() {
		return condicaoMedica;
	}

	public void setCondicaoMedica(String condicaoMedica) {
		this.condicaoMedica = condicaoMedica;
	}

}
