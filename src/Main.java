import javax.swing.JOptionPane;

import controller.AgendamentoController;
import controller.PacienteController;
import model.persistence.DatabaseConnection;
import view.guiMenu.MenuPanel;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.connectAndExecute();

		PacienteController pacienteController = new PacienteController();
		AgendamentoController agendamentoController = new AgendamentoController();
//		AgendamentoDTO agendamentoDTO = new AgendamentoDTO(LocalDateTime.parse("2024-06-06T10:30:00"), 1,
//				"Medica paulinha2", EnumTipoExame.ECOCARDIOGRAMA.getValue());
		try {
//			agendamentoController.create(agendamentoDTO);
//			System.out.println(pacienteController.getAll());
			System.out.println("id paciente: "
					+ pacienteController.searchByField("cpf", "123.456.789-01").get(0).getPessoa().getId());
			System.out
					.println("id pessoa: " + pacienteController.searchByField("cpf", "123.456.789-01").get(0).getId());

			System.out.println(agendamentoController.getAll());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuPanel tela = new MenuPanel();
				tela.setVisible(true);
			}
		});

	}
}
