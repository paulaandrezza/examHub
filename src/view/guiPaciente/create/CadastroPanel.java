package view.guiPaciente.create;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.PacienteController;
import model.persistence.dao.paciente.PacienteFullDTO;
import view.img.SVGIconUtil;

public class CadastroPanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);

	private PacienteController pacienteController = new PacienteController();
	private PacienteFullDTO pacienteFullDTO = new PacienteFullDTO();

	private PessoaPanel pessoaPanel = new PessoaPanel(pacienteFullDTO, this);
	private PacientePanel pacientePanel = new PacientePanel(pacienteFullDTO, this);
	private EnderecoPanel enderecoPanel = new EnderecoPanel(pacienteController, pacienteFullDTO, this);

	/**
	 * Create the frame.
	 */
	public CadastroPanel() {
		setBackground(SystemColor.menu);
		setTitle("Cadastro de Novo Paciente *");
		setVisible(true);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		setLocation(50, 50);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		tabbedPanel.setEnabled(false);

		try {
			ImageIcon iconPessoais = SVGIconUtil.createImageIcon("../img/angle-right.svg");
			ImageIcon iconMedicos = SVGIconUtil.createImageIcon("../img/angle-right.svg");
			ImageIcon iconMoradia = SVGIconUtil.createImageIcon("../img/check-square.svg");

			JLabel labelPessoais = new JLabel("Dados Pessoais", iconPessoais, SwingConstants.RIGHT);
			JLabel labelMedicos = new JLabel("Dados Médicos", iconMedicos, SwingConstants.RIGHT);
			JLabel labelMoradia = new JLabel("Dados de Moradia", iconMoradia, SwingConstants.RIGHT);

			labelPessoais.setIconTextGap(5);
			labelMedicos.setIconTextGap(5);
			labelMoradia.setIconTextGap(5);

			tabbedPanel.addTab(null, null, pessoaPanel);
			tabbedPanel.setTabComponentAt(tabbedPanel.indexOfComponent(pessoaPanel), labelPessoais);
			tabbedPanel.addTab("Dados Médicos", pacientePanel);
			tabbedPanel.setTabComponentAt(tabbedPanel.indexOfComponent(pacientePanel), labelMedicos);
			tabbedPanel.addTab("Dados de Moradia", enderecoPanel);
			tabbedPanel.setTabComponentAt(tabbedPanel.indexOfComponent(enderecoPanel), labelMoradia);
		} catch (IOException e) {
			System.out.println("Erro ao carregar o ícone");
			e.printStackTrace();
		}

		contentPane.add(tabbedPanel, BorderLayout.CENTER);

		this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	}

	public String errorMessage() {
		return "Por favor, preencha todos os campos corretamente antes de prosseguir.";
	}

	public void switchToNextTab() {
		int currentIndex = tabbedPanel.getSelectedIndex();
		int nextIndex = currentIndex + 1;
		if (nextIndex < tabbedPanel.getTabCount()) {
			tabbedPanel.setSelectedIndex(nextIndex);
		}
	}

	public void switchToBackTab() {
		int currentIndex = tabbedPanel.getSelectedIndex();
		int nextIndex = currentIndex - 1;
		if (nextIndex >= 0) {
			tabbedPanel.setSelectedIndex(nextIndex);
		}
	}

	public void switchToCancelTab() {
		int resposta = JOptionPane.showConfirmDialog(null, "Esta ação irá apagar todos os dados salvos.",
				"Apagar Dados", JOptionPane.OK_CANCEL_OPTION);
		if (resposta == JOptionPane.OK_OPTION) {
			tabbedPanel.setSelectedIndex(0);

			pessoaPanel.clearPessoaFields();
			pacientePanel.clearPacienteFields();
			enderecoPanel.clearEnderecoFields();
		}
	}
}
