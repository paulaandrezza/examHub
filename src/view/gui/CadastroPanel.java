package view.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controller.PacienteController;
import model.persistence.dao.paciente.PacienteFullDTO;

public class CadastroPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	PacienteController pacienteController = new PacienteController();
	PacienteFullDTO pacienteFullDTO = new PacienteFullDTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPanel frame = new CadastroPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroPanel() {
		setMinimumSize(new Dimension(800, 700));
		setBackground(SystemColor.menu);
		setTitle("Cadastro de Novo Paciente *");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
		// PessoaPanel - Dados Pessoais
		PessoaPanel pessoaPanel = new PessoaPanel(pacienteFullDTO);
		tabbedPanel.addTab("Dados Pessoais", pessoaPanel);
		// PacientePanel - Dados médicos
		PacientePanel pacientePanel = new PacientePanel(pacienteFullDTO);
		tabbedPanel.addTab("Dados Médicos", pacientePanel);
		// EnderecoPanel - Endereço
		EnderecoPanel enderecoPanel = new EnderecoPanel(pacienteController, pacienteFullDTO);
		tabbedPanel.addTab("Dados de Moradia", enderecoPanel);
		contentPane.add(tabbedPanel);

		contentPane.add(tabbedPanel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
