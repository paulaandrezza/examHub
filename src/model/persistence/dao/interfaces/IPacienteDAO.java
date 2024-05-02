package model.persistence.dao.interfaces;

import model.entities.Convenio;
import model.entities.Endereco;
import model.entities.HistoricoMedico;
import model.entities.Paciente;
import model.entities.Pessoa;

public interface IPacienteDAO {
	int save(Endereco endereco, Convenio convenio, HistoricoMedico historicoMedico, Pessoa pessoa, Paciente paciente);
}
