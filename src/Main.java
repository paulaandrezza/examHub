import model.persistence.DatabaseConnection;
import view.gui.CadastroPanel;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.connectAndExecute();

		/*
		 * PacienteController pacienteController = new PacienteController();
		 * PacienteFullDTO pacienteFullDTO = new PacienteFullDTO("João Silva",
		 * "123.456.789-00", "123.456.789-X", LocalDate.of(2000, 3, 25), 11987654321L,
		 * 1132109876L, "joao@example.com", EnumGenero.MASCULINO, 123456, "SP",
		 * "São Paulo", "Centro", "Rua A", "100", "Apt 101", 1.75f, false, false,
		 * 987654321, "Saúde Plena", "Plano Premium", "Nenhum", "Paracetamol",
		 * "Tomar 1 vez ao dia");
		 * 
		 * int pacienteId = pacienteController.create(pacienteFullDTO);
		 * System.out.println(pacienteId);
		 * System.out.println(pacienteController.getAll());
		 * System.out.println("\nJoão Silva: " +
		 * pacienteController.searchByField("nome", "João Silva"));
		 * System.out.println("\nNão Fumantes: " +
		 * pacienteController.searchByField("fumante", false));
		 * 
		 * // TODO: Delete não está funcionando em cascade mode, só apaga o registro em
		 * // Paciente. // System.out.println("\n" + pacienteController.getAll()); //
		 * pacienteController.delete(2); System.out.println("\n" +
		 * pacienteController.getAll());
		 */

		// System.out.println("\n\njava.util.Date: " + new Date(2000, 03, 25));
		// System.out.println("sql.date: " + new java.sql.Date(2000, 03, 25));
		// System.out.println("java.time.LocalDate: " + LocalDate.of(2000, 3, 25));
		// System.out.println("java.time.LocalTime: " + LocalTime.of(10, 20));
		// System.out.println("java.time.LocalDateTime: " + LocalDateTime.of(200, 03,
		// 25, 10, 20));
		// System.out.println("java.sql.Timestamp: " + new java.sql.Timestamp(2000, 03,
		// 25, 10, 20, 0, 0));

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CadastroPanel tela = new CadastroPanel();
				tela.setVisible(true);
			}
		});
	}
}
