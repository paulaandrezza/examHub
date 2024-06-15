import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import controller.AgendamentoController;
import model.enums.EnumTipoExame;
import model.persistence.DatabaseConnection;
import model.persistence.dao.agendamento.AgendamentoDTO;
import view.guiMenu.MenuPanel;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.connectAndExecute();

		AgendamentoController agendamentoController = new AgendamentoController();
		AgendamentoDTO agendamentoDTO = new AgendamentoDTO(LocalDateTime.parse("2024-06-06T10:30:00"), 1,
				"Medica paulinha", EnumTipoExame.ECOCARDIOGRAMA.getValue());
		try {
			agendamentoController.create(agendamentoDTO);
			System.out.println(agendamentoController.getAll());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

//		AuthController authController = new AuthController();
//		try {
//			EnumTipoFuncionario tipoFuncionario = authController.auth("paula.marinho@examhub.com", "password123");
//			JOptionPane.showMessageDialog(null,
//					"Login bem-sucedido! Tipo de funcionário: " + tipoFuncionario.getDescription());
//		} catch (EmailAndPasswordIncorrectException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}
//
//		try {
//			EnumTipoFuncionario tipoFuncionario = authController.auth("emailerrado@email.com", "senhaerrada");
//			JOptionPane.showMessageDialog(null, "Login bem-sucedido! Tipo de funcionário: " + tipoFuncionario);
//		} catch (EmailAndPasswordIncorrectException e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		} catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage());
//		}

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
				MenuPanel tela = new MenuPanel();
				tela.setVisible(true);
			}
		});

	}
}
