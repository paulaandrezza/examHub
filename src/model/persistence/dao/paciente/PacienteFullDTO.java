package model.persistence.dao.paciente;

import java.util.Date;

import model.entities.Convenio;
import model.entities.HistoricoMedico;
import model.enums.Genero;

public class PacienteFullDTO {
	private int idPaciente;

    private String nome;
    private String cpf;
    private Date dataNascimento;
    private long celular;
    private long telefone;
    private String email;
    private Genero genero;

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
    
	public PacienteFullDTO(int idPaciente, String nome, String cpf, Date dataNascimento, long celular, long telefone,
			String email, Genero genero, int cep, String estado, String cidade, String bairro, String rua,
			String numero, String complemento, float altura, boolean fumante, boolean marcaPasso, int numeroCarteirinha,
			String prestadora, String plano, String alergias, String medicamentos, String prescricao) {
		super();
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
	
	
}
