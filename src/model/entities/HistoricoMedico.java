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
		return "HistoricoMedico [alergias=" + alergias + ", medicamentos=" + medicamentos + ", condicaoMedica="
				+ condicaoMedica + "]";
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
