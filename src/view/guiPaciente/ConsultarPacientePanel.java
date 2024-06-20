package view.guiPaciente;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import controller.PacienteController;
import model.entities.Convenio;
import model.entities.Paciente;
import model.entities.Pessoa;

public class ConsultarPacientePanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textPesquisar;
	private JTable table;
	private DefaultTableModel tableModel;

	public ConsultarPacientePanel() {
		setBounds(100, 100, 768, 811);
		getContentPane().setLayout(null);

		Box tituloBoxVerticalListaPaciente = Box.createVerticalBox();
		tituloBoxVerticalListaPaciente.setBounds(10, 10, 1000, 45);
		getContentPane().add(tituloBoxVerticalListaPaciente);

		JLabel labelListaPacienteTitulo = new JLabel("LISTA PACIENTE");
		labelListaPacienteTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelListaPacienteTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalListaPaciente.add(labelListaPacienteTitulo);

		JSeparator hr_listapaciente_1 = new JSeparator();
		tituloBoxVerticalListaPaciente.add(hr_listapaciente_1);

		Box boxVerticalListaPaciente = Box.createHorizontalBox();
		boxVerticalListaPaciente.setBounds(125, 70, 750, 32);
		getContentPane().add(boxVerticalListaPaciente);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnPesquisar.setAlignmentX(1.0f);
		boxVerticalListaPaciente.add(btnPesquisar);

		textPesquisar = new JTextField();
		textPesquisar.setFont(new Font("Verdana", Font.PLAIN, 12));
		textPesquisar.setColumns(10);
		boxVerticalListaPaciente.add(textPesquisar);

		table = new JTable() {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 4 || column == 5;
			}
		};
		table.setShowVerticalLines(false);
		table.setFont(new Font("Verdana", Font.PLAIN, 10));
		table.setRowSelectionAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 120, 1000, 650);
		getContentPane().add(scrollPane);

		String[] columnNames = { "Nome do Paciente", "RG", "CPF", "Plano", "Editar", "Deletar", "ID" };
		tableModel = new DefaultTableModel(columnNames, 0);
		table.setModel(tableModel);

		loadAllPatients();

		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String searchText = textPesquisar.getText().trim();
				if (!searchText.isEmpty()) {
					tableModel.setRowCount(0);
					searchPatients(searchText);
				} else {
					tableModel.setRowCount(0);
					loadAllPatients();
				}
			}
		});

		TableColumnModel columnModel = table.getColumnModel();
		int[] columnWidths = { 160, 80, 80, 150, 70, 70, 0 };
		for (int i = 0; i < columnWidths.length; i++) {
			TableColumn column = columnModel.getColumn(i);
			column.setPreferredWidth(columnWidths[i]);
			if (i == 6) {
				column.setMinWidth(0);
				column.setMaxWidth(0);
				column.setWidth(0);
				column.setPreferredWidth(0);
			}
		}

		columnModel.getColumn(4).setCellRenderer(new ButtonRenderer());
		columnModel.getColumn(4).setCellEditor(new ButtonEditor(new JButton("Editar")));
		columnModel.getColumn(5).setCellRenderer(new ButtonRenderer());
		columnModel.getColumn(5).setCellEditor(new ButtonEditor(new JButton("Deletar")));
	}

	private void loadAllPatients() {
		PacienteController pacienteController = new PacienteController();
		List<Paciente> listapacientes = pacienteController.getAll();

		for (Paciente paciente : listapacientes) {
			Pessoa pessoa = paciente.getPessoa();
			String nome = pessoa.getNome();
			String rg = pessoa.getRg();
			String cpf = pessoa.getCpf();

			Convenio convenio = paciente.getConvenio();
			String plano = convenio.getPlano();

			Object[] rowData = { nome, rg, cpf, plano, "Editar", "Deletar", paciente.getId() };
			tableModel.addRow(rowData);
		}
	}

	private void searchPatients(String searchText) {
		PacienteController pacienteController = new PacienteController();
		List<Paciente> listapacientes = new ArrayList<>();

		try {
			List<Paciente> pacientesPorNome = pacienteController.searchByField("nome", searchText);
			listapacientes.addAll(pacientesPorNome);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		tableModel.setRowCount(0);

		for (Paciente paciente : listapacientes) {
			Pessoa pessoa = paciente.getPessoa();
			String nome = pessoa.getNome();
			String rg = pessoa.getRg();
			String cpf = pessoa.getCpf();

			Convenio convenio = paciente.getConvenio();
			String plano = convenio.getPlano();

			Object[] rowData = { nome, rg, cpf, plano, "Editar", "Deletar", paciente.getId() };
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
				int selectedRow = table.getSelectedRow();
				int patientId = (Integer) table.getValueAt(selectedRow, 6);
				if (label.equals("Editar")) {
					System.out.println("Botão Editar pressionado na linha: " + selectedRow + " com ID: " + patientId);
					// Adicione a lógica para editar o paciente aqui
				} else if (label.equals("Deletar")) {
					System.out.println("Botão Deletar pressionado na linha: " + selectedRow + " com ID: " + patientId);

					String menssagem = String.format(
							"Essa ação irá deletar os dados de %s%nClique em OK se deseja continuar com a ação.",
							table.getValueAt(selectedRow, 0));

					int resposta = JOptionPane.showConfirmDialog(null, menssagem, "Warning",
							JOptionPane.OK_CANCEL_OPTION);
					if (resposta == JOptionPane.OK_OPTION) {
						DeletarPaciente delete = new DeletarPaciente(patientId);
						JOptionPane.showMessageDialog(null, "Paciente deletado com sucesso!", "Sucesso",
								JOptionPane.INFORMATION_MESSAGE);
					}

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
