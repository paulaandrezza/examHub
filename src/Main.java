import java.util.Date;

import controller.PacienteController;
import model.enums.Genero;
import model.persistence.DatabaseConnection;
import model.persistence.dao.paciente.PacienteFullDTO;
import view.TelaCadastroPaciente;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.connectAndExecute();

		PacienteController pacienteController = new PacienteController();
		PacienteFullDTO pacienteFullDTO = new PacienteFullDTO("João Silva", "123.456.789-00", new Date(), 11987654321L,
				1132109876L, "joao@example.com", Genero.MASCULINO, 123456, "SP", "São Paulo", "Centro", "Rua A", "100",
				"Apt 101", 1.75f, false, false, 987654321, "Saúde Plena", "Plano Premium", "Nenhum", "Paracetamol",
				"Tomar 1 vez ao dia");

		pacienteController.create(pacienteFullDTO);
		System.out.println(pacienteController.getAll());
		System.out.println("\nJoão Silva: " + pacienteController.searchByField("nome", "João Silva"));
		System.out.println("\nNão Fumantes: " + pacienteController.searchByField("fumante", false));

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				TelaCadastroPaciente tela = new TelaCadastroPaciente();
				tela.setVisible(true);
			}
		});
	}

}
