package model.entities;

public class HistoricoMedico extends BaseEntity {
	String alergias;
	String medicamentos;
	String prescicao;
	
	public HistoricoMedico(int id, String alergias, String medicamentos, String prescicao) {
		super(id);
		this.alergias = alergias;
		this.medicamentos = medicamentos;
		this.prescicao = prescicao;
	}
}
