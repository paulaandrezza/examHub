package model.entities;

public class HistoricoMedico extends BaseEntity {
	String alergias;
	String medicamentos;
	String prescricao;

	public HistoricoMedico(int id, String alergias, String medicamentos, String prescricao) {
		super(id);
		this.alergias = alergias;
		this.medicamentos = medicamentos;
		this.prescricao = prescricao;
	}

	public HistoricoMedico(String alergias, String medicamentos, String prescricao) {
		this.alergias = alergias;
		this.medicamentos = medicamentos;
		this.prescricao = prescricao;
	}

	@Override
	public String toString() {
		return "HistoricoMedico [alergias=" + alergias + ", medicamentos=" + medicamentos + ", prescricao=" + prescricao
				+ "]";
	}

}
