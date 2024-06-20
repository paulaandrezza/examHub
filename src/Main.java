import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import controller.AgendamentoController;
import model.enums.EnumTipoExame;
import controller.AgendamentoController;
import model.enums.EnumTipoExame;
import model.persistence.DatabaseConnection;
import model.persistence.dao.agendamento.AgendamentoDTO;
import model.persistence.dao.agendamento.AgendamentoDTO;
import view.guiMenu.MenuPanel;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.connectAndExecute();

		AgendamentoController agendamentoController = new AgendamentoController();
		AgendamentoDTO agendamentoDTO = new AgendamentoDTO(LocalDateTime.parse("2024-06-06T10:30:00"), 1,
				"Medica paulinha", EnumTipoExame.ECOCARDIOGRAMA.getValue());

		PacienteController pacienteController = new PacienteController();

		try {
			System.out.println("\n\n" + pacienteController.getByEmail("michele.nonato@example.com") + "\n\n");

			agendamentoController.create(agendamentoDTO);
			System.out.println(agendamentoController.getAll());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginPanel tela = new LoginPanel();
				tela.setVisible(true);
			}
		});


	}
}
