package model.persistence.dao.paciente;

import model.entities.Convenio;
import model.entities.HistoricoMedico;
import model.entities.Pessoa;

public class PacienteDTO {
	float altura;
	boolean fumante;
	boolean marcaPasso;
	int convenio_id;
	int historicoMedico_id;
	int pessoa_id;
	
	public PacienteDTO(float altura, boolean fumante, boolean marcaPasso, int convenio_id, int historicoMedico_id,
			int pessoa_id) {
		super();
		this.altura = altura;
		this.fumante = fumante;
		this.marcaPasso = marcaPasso;
		this.convenio_id = convenio_id;
		this.historicoMedico_id = historicoMedico_id;
		this.pessoa_id = pessoa_id;
	}
}
