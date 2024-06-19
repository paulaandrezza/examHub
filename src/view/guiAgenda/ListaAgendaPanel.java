package view.guiAgenda;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import controller.AgendamentoController;
import model.entities.exames.Agendamento;
import model.enums.EnumStatusAgendamento;
import model.enums.EnumTipoExame;
import model.exceptions.EntityNotFoundException;

public class ListaAgendaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel tableModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
					frame.setContentPane(new ListaAgendaPanel());
					frame.setBounds(100, 100, 900, 811);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ListaAgendaPanel() throws SQLException, EntityNotFoundException {
		setBounds(100, 100, 900, 811);
		setLayout(null);

		Box tituloBoxVerticalListaAgenda = Box.createVerticalBox();
		tituloBoxVerticalListaAgenda.setBounds(10, 10, 880, 45);
		add(tituloBoxVerticalListaAgenda);

		JLabel labelListaAgendaTitulo = new JLabel("LISTA AGENDA");
		labelListaAgendaTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelListaAgendaTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalListaAgenda.add(labelListaAgendaTitulo);

		JSeparator hr_listaagenda_1 = new JSeparator();
		tituloBoxVerticalListaAgenda.add(hr_listaagenda_1);

		table = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 5 || column == 6;
			}
		};
		table.setShowVerticalLines(false);
		table.setFont(new Font("Verdana", Font.PLAIN, 10));
		table.setRowSelectionAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 70, 740, 650);
		add(scrollPane);

		String[] columnNames = { "Nome do Paciente", "Data", "Hora", "Exame", "Status", "Editar", "Deletar" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table.setModel(tableModel);

		AgendamentoController agendamentoController = new AgendamentoController();
		List<Agendamento> listaAgendamentos = agendamentoController.getAll();

		for (Agendamento agendamento : listaAgendamentos) {
			LocalDate data = agendamento.getDataEhorario().toLocalDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = data.format(formatter);
			LocalTime hora = agendamento.getDataEhorario().toLocalTime();

			String nome = agendamento.getPaciente().getPessoa().getNome();
			EnumTipoExame exame = agendamento.getTipoExame();
			EnumStatusAgendamento status = agendamento.getStatusAgendamento();

			Object[] rowData = { nome, dataFormatada, hora, exame, status, "Editar", "Deletar" };
			tableModel.addRow(rowData);
		}

		TableColumnModel columnModel = table.getColumnModel();
		int[] columnWidths = { 160, 80, 50, 150, 90, 70, 70 };
		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = columnModel.getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
		}

		columnModel.getColumn(5).setCellRenderer(new ButtonRenderer());
		columnModel.getColumn(5).setCellEditor(new ButtonEditor(new JButton("Editar")));
		columnModel.getColumn(6).setCellRenderer(new ButtonRenderer());
		columnModel.getColumn(6).setCellEditor(new ButtonEditor(new JButton("Deletar")));
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

	@SuppressWarnings("serial")
	class ButtonEditor extends DefaultCellEditor {
		private String label;
		private JButton button;
		private boolean isPushed;

		public ButtonEditor(JButton button) {
			super(new JCheckBox());
			this.button = button;
			this.button.setOpaque(true);
			this.button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
				}
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			isPushed = true;
			return button;
		}

		@Override
		public Object getCellEditorValue() {
			if (isPushed) {
				if (label.equals("Editar")) {
					System.out.println("Botão Editar pressionado na linha: " + table.getSelectedRow());
				} else if (label.equals("Deletar")) {
					System.out.println("Botão Deletar pressionado na linha: " + table.getSelectedRow());
				}
			}
			isPushed = false;
			return new String(label);
		}

		@Override
		public boolean stopCellEditing() {
			isPushed = false;
			return super.stopCellEditing();
		}

		@Override
		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}
}
