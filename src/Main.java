import javax.swing.JOptionPane;

import controller.AgendamentoController;
import controller.ExameController;
import model.persistence.DatabaseConnection;
import view.guiLogin.LoginPanel;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
		dbConnection.connectAndExecute();

		AgendamentoController agendamentoController = new AgendamentoController();
		ExameController exameController = new ExameController();

		try {
//			// Criar agendamento para Ecocardiograma
//			AgendamentoDTO agendamentoEcocardiogramaDTO = new AgendamentoDTO(LocalDateTime.parse("2024-06-06T10:30:00"),
//					1, "Medico Dr. João", EnumTipoExame.ECOCARDIOGRAMA.getValue());
//			int idAgendamentoEcocardiograma = agendamentoController.create(agendamentoEcocardiogramaDTO);
//
//			EcocardiogramaDTO ecocardiogramaDTO = new EcocardiogramaDTO(40, 1, "Conclusão Ecocardiograma",
//					"Detalhes Ecocardiograma", EnumDiagnostico.NORMAL_CRIANCA.getValue(), idAgendamentoEcocardiograma,
//					10, 10, 10, 10, 10, 6, 7, (float) 0.5);
//			exameController.create(ecocardiogramaDTO);
//
//			// Criar agendamento para Eletrocardiograma
//			AgendamentoDTO agendamentoEletrocardiogramaDTO = new AgendamentoDTO(
//					LocalDateTime.parse("2024-06-07T11:00:00"), 1, "Medica Dra. Maria",
//					EnumTipoExame.ELETROCARDIOGRAMA.getValue());
//			int idAgendamentoEletrocardiograma = agendamentoController.create(agendamentoEletrocardiogramaDTO);
//
//			EletrocardiogramaDTO eletrocardiogramaDTO = new EletrocardiogramaDTO(50, 1, "Ritmo ECG", "Detalhes",
//					EnumDiagnostico.NORMAL_CRIANCA.getValue(), idAgendamentoEletrocardiograma, "ritmo", 20, (float) 0.2,
//					100, 10);
//			exameController.create(eletrocardiogramaDTO);
//
//			// Criar agendamento para Holter
//			AgendamentoDTO agendamentoHolterDTO = new AgendamentoDTO(LocalDateTime.parse("2024-06-08T14:30:00"), 1,
//					"Medico Dr. Carlos", EnumTipoExame.HOLTER.getValue());
//			int idAgendamentoHolter = agendamentoController.create(agendamentoHolterDTO);
//
//			HolterDTO holterDTO = new HolterDTO(60, 1, "Holter", "Holter", EnumDiagnostico.NORMAL_CRIANCA.getValue(),
//					idAgendamentoHolter, 10, 10, 10, 10, true);
//			exameController.create(holterDTO);
//
//			// Criar agendamento para Mapa
//			AgendamentoDTO agendamentoMapaDTO = new AgendamentoDTO(LocalDateTime.parse("2024-06-09T16:00:00"), 1,
//					"Medica Dra. Ana", EnumTipoExame.MAPA.getValue());
//			int idAgendamentoMapa = agendamentoController.create(agendamentoMapaDTO);
//
//			MapaDTO mapaDTO = new MapaDTO(70, 1, "mapa", "mapa", EnumDiagnostico.NORMAL_ADULTO.getValue(),
//					idAgendamentoMapa, "50h", "10", "sono");
//			exameController.create(mapaDTO);
//
//			// Criar agendamento para Teste Ergométrico
//			AgendamentoDTO agendamentoTesteErgometricoDTO = new AgendamentoDTO(
//					LocalDateTime.parse("2024-06-10T09:00:00"), 1, "Medico Dr. Pedro",
//					EnumTipoExame.TESTE_ERGOMETRICO.getValue());
//			int idAgendamentoTesteErgometrico = agendamentoController.create(agendamentoTesteErgometricoDTO);
//
//			System.out.println(idAgendamentoTesteErgometrico);
//
//			TesteErgometricoDTO testeErgometricoDTO = new TesteErgometricoDTO(80, 1, "testeErgometrico",
//					"testeErgometrico", EnumDiagnostico.NORMAL_ADULTO.getValue(), idAgendamentoTesteErgometrico, 120,
//					80);
//
//			exameController.create(testeErgometricoDTO);

			System.out.println(exameController.getAll());

//			pacienteController.delete(1);

//			System.out.println(agendamentoController.getAll());
		} catch (Exception e) {
			System.out.println(e.fillInStackTrace());
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
