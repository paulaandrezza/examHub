package view.guiAgenda;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controller.AgendamentoController;
import model.entities.exames.Agendamento;
import model.exceptions.EntityNotFoundException;

public class AgendaPanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgendaPanel frame = new AgendaPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws EntityNotFoundException
	 * @throws SQLException
	 */
	public AgendaPanel() throws SQLException, EntityNotFoundException {
		setBounds(100, 100, 768, 811);
		getContentPane().setLayout(null);

		Box tituloBoxVerticalListaAgenda = Box.createVerticalBox();
		tituloBoxVerticalListaAgenda.setBounds(10, 10, 750, 45);
		getContentPane().add(tituloBoxVerticalListaAgenda);

		JLabel labelListaAgendaTitulo = new JLabel("LISTA AGENDA");
		labelListaAgendaTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelListaAgendaTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalListaAgenda.add(labelListaAgendaTitulo);

		JSeparator hr_listaagenda_1 = new JSeparator();
		tituloBoxVerticalListaAgenda.add(hr_listaagenda_1);

		JTable table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 70, 750, 700);
		getContentPane().add(scrollPane);

		String[] columnNames = { "Nome", "Data", "Hora", "Médico Solicitante", "Editar", "Excluir" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		table.setModel(tableModel);

		AgendamentoController agendamentoController = new AgendamentoController();
		List<Agendamento> listaAgendamentos = agendamentoController.getAll();

		for (Agendamento agendamento : listaAgendamentos) {
			LocalDate data = agendamento.getDataEhorario().toLocalDate();
			LocalTime hora = agendamento.getDataEhorario().toLocalTime();

			Object[] rowData = { agendamento.getPaciente().getPessoa().getNome(), data, hora,
					agendamento.getMedicoSolicitante(), "Editar", "Excluir" };
			tableModel.addRow(rowData);
		}

		table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer());
		table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
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
