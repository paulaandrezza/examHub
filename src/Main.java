import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import controller.AgendamentoController;
import model.persistence.DatabaseConnection;
import model.persistence.dao.agendamento.AgendamentoDTO;
import view.guiMenu.MenuPanel;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.connectAndExecute();

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginPanel tela = new LoginPanel();
				tela.setVisible(true);
			}
		});


	}
}
