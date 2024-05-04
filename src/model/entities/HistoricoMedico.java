package model.entities;

public class HistoricoMedico extends BaseEntity {
	String alergias;
	String medicamentos;
	String condicaoMedica;

	public HistoricoMedico(int id, String alergias, String medicamentos, String condicaoMedica) {
		super(id);
		this.alergias = alergias;
		this.medicamentos = medicamentos;
		this.condicaoMedica = condicaoMedica;
	}

	public HistoricoMedico(String alergias, String medicamentos, String condicaoMedica) {
		this.alergias = alergias;
		this.medicamentos = medicamentos;
		this.condicaoMedica = condicaoMedica;
	}

	@Override
	public String toString() {
		return "HistoricoMedico [alergias=" + alergias + ", medicamentos=" + medicamentos + ", condicaoMedica=" + condicaoMedica
				+ "]";
	}

}
