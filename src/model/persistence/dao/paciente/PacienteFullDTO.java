package model.persistence.dao.paciente;

import java.time.LocalDate;

import model.enums.EnumGenero;

public class PacienteFullDTO {
	private int idPaciente;

	private String nome;
	private String cpf;
	private LocalDate dataNascimento;
	private long celular;
	private long telefone;
	private String email;
	private EnumGenero genero;

	private int cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;

	private float altura;
	private boolean fumante;
	private boolean marcaPasso;

	private int numeroCarteirinha;
	private String prestadora;
	private String plano;

	private String alergias;
	private String medicamentos;
	private String prescricao;

	public PacienteFullDTO(int idPaciente, String nome, String cpf, LocalDate dataNascimento, long celular,
			long telefone, String email, EnumGenero genero, int cep, String estado, String cidade, String bairro,
			String rua, String numero, String complemento, float altura, boolean fumante, boolean marcaPasso,
			int numeroCarteirinha, String prestadora, String plano, String alergias, String medicamentos,
			String prescricao) {
		this.idPaciente = idPaciente;
		this.nome = nome;
		this.cpf = cpf;
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
		this.prescricao = prescricao;
	}

	public PacienteFullDTO(String nome, String cpf, LocalDate dataNascimento, long celular, long telefone, String email,
			EnumGenero genero, int cep, String estado, String cidade, String bairro, String rua, String numero,
			String complemento, float altura, boolean fumante, boolean marcaPasso, int numeroCarteirinha,
			String prestadora, String plano, String alergias, String medicamentos, String prescricao) {
		this.nome = nome;
		this.cpf = cpf;
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
		this.prescricao = prescricao;
	}

	@Override
	public String toString() {
		return "PacienteDTO [idPaciente=" + idPaciente + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + ", celular=" + celular + ", telefone=" + telefone + ", email=" + email + ", genero="
				+ genero + ", cep=" + cep + ", estado=" + estado + ", cidade=" + cidade + ", bairro=" + bairro
				+ ", rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", altura=" + altura
				+ ", fumante=" + fumante + ", marcaPasso=" + marcaPasso + ", numeroCarteirinha=" + numeroCarteirinha
				+ ", prestadora=" + prestadora + ", plano=" + plano + ", alergias=" + alergias + ", medicamentos="
				+ medicamentos + ", prescricao=" + prescricao + "]";
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
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

	public String getPrescricao() {
		return prescricao;
	}

	public void setPrescricao(String prescricao) {
		this.prescricao = prescricao;
	}

}
