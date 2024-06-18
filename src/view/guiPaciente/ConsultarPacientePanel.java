package view.guiPaciente;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

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
		tituloBoxVerticalListaPaciente.setBounds(10, 10, 750, 45);
		getContentPane().add(tituloBoxVerticalListaPaciente);

		JLabel labelListaPacienteTitulo = new JLabel("LISTA PACIENTE");
		labelListaPacienteTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelListaPacienteTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalListaPaciente.add(labelListaPacienteTitulo);

		JSeparator hr_listapaciente_1 = new JSeparator();
		tituloBoxVerticalListaPaciente.add(hr_listapaciente_1);

		Box boxVerticalListaPaciente = Box.createHorizontalBox();
		boxVerticalListaPaciente.setBounds(10, 70, 750, 32);
		getContentPane().add(boxVerticalListaPaciente);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Verdana", Font.BOLD, 12));
		btnPesquisar.setAlignmentX(1.0f);
		boxVerticalListaPaciente.add(btnPesquisar);

		textPesquisar = new JTextField();
		textPesquisar.setFont(new Font("Verdana", Font.PLAIN, 12));
		textPesquisar.setColumns(10);
		boxVerticalListaPaciente.add(textPesquisar);

		table = new JTable();
		table.setEnabled(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 120, 750, 650);
		getContentPane().add(scrollPane);

		String[] columnNames = { "Nome do Paciente", "RG", "CPF", "Plano" };
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

			Object[] rowData = { nome, rg, cpf, plano };
			tableModel.addRow(rowData);
		}
	}

	private void searchPatients(String searchText) {
		PacienteController pacienteController = new PacienteController();
		List<Paciente> listapacientes = new ArrayList<>();

		List<Paciente> pacientesPorNome = pacienteController.searchByField("nome", searchText);
		listapacientes.addAll(pacientesPorNome);

		tableModel.setRowCount(0);

		for (Paciente paciente : listapacientes) {
			Pessoa pessoa = paciente.getPessoa();
			String nome = pessoa.getNome();
			String rg = pessoa.getRg();
			String cpf = pessoa.getCpf();

			Convenio convenio = paciente.getConvenio();
			String plano = convenio.getPlano();

			Object[] rowData = { nome, rg, cpf, plano };
			tableModel.addRow(rowData);
		}
	}

}
