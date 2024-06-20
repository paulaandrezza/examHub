package view.guiPaciente.delete;

import java.sql.SQLException;

import controller.PacienteController;
import model.exceptions.EntityNotFoundException;

public class DeletarPaciente {
	private int id;

	public DeletarPaciente(int id) {
		super();
		this.id = id;
	}

	public void delete() throws SQLException, EntityNotFoundException {
		PacienteController paciente = new PacienteController();
		paciente.delete(id);
	}

}
