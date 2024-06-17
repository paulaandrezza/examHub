package view.guiAgenda;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controller.AgendamentoController;
import model.entities.exames.Agendamento;
import model.exceptions.EntityNotFoundException;

public class ListaAgendaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setContentPane(new ListaAgendaPanel());
					frame.setBounds(100, 100, 768, 811);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the panel.
	 * 
	 * @throws EntityNotFoundException
	 * @throws SQLException
	 */
	public ListaAgendaPanel() throws SQLException, EntityNotFoundException {
		setBounds(100, 100, 768, 811);
		setLayout(null);

		Box tituloBoxVerticalListaAgenda = Box.createVerticalBox();
		tituloBoxVerticalListaAgenda.setBounds(10, 10, 750, 45);
		add(tituloBoxVerticalListaAgenda);

		JLabel labelListaAgendaTitulo = new JLabel("LISTA AGENDA");
		labelListaAgendaTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelListaAgendaTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalListaAgenda.add(labelListaAgendaTitulo);

		JSeparator hr_listaagenda_1 = new JSeparator();
		tituloBoxVerticalListaAgenda.add(hr_listaagenda_1);

		JTable table = new JTable();
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 70, 750, 700);
		add(scrollPane);

		String[] columnNames = { "Nome do Paciente", "Data", "Hora", "Médico Solicitante" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		table.setModel(tableModel);

		AgendamentoController agendamentoController = new AgendamentoController();
		List<Agendamento> listaAgendamentos = agendamentoController.getAll();

		for (Agendamento agendamento : listaAgendamentos) {
			LocalDate data = agendamento.getDataEhorario().toLocalDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = data.format(formatter);
			LocalTime hora = agendamento.getDataEhorario().toLocalTime();

			Object[] rowData = { agendamento.getPaciente().getPessoa().getNome(), dataFormatada, hora,
					agendamento.getMedicoSolicitante() };
			tableModel.addRow(rowData);
		}
	}

	@SuppressWarnings("serial")
	class ButtonRenderer extends JButton implements TableCellRenderer {

		public ButtonRenderer() {
			setOpaque(true);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText((value == null) ? "" : value.toString());
			return this;
		}
	}
}
