package view.guiAgenda;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.sql.SQLException;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import controller.AgendamentoController;
import model.exceptions.EntityNotFoundException;

public class AgendaPanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTabbedPane tabbedPanel = new JTabbedPane(JTabbedPane.TOP);
	private JPanel contentPane;

	private AgendamentoController agendamentoController = new AgendamentoController();
	private ListaAgendaPanel listaAgendaPanel;
	private CadastrarAgendaPanel cadastrarAgendaPanel = new CadastrarAgendaPanel(agendamentoController, this);

	public AgendaPanel() {
		setBackground(SystemColor.menu);
		setTitle("Manter Agenda");
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

		try {
			listaAgendaPanel = new ListaAgendaPanel();

			JLabel labelListaAgenda = new JLabel("Lista Agendas");
			JLabel labelCadastrarAgenda = new JLabel("Cadastrar Nova Agenda");

			labelListaAgenda.setIconTextGap(5);
			labelCadastrarAgenda.setIconTextGap(5);

			tabbedPanel.addTab(null, null, listaAgendaPanel);
			tabbedPanel.setTabComponentAt(tabbedPanel.indexOfComponent(listaAgendaPanel), labelListaAgenda);
			tabbedPanel.addTab("Cadastrar Agenda", cadastrarAgendaPanel);
			tabbedPanel.setTabComponentAt(tabbedPanel.indexOfComponent(listaAgendaPanel), labelListaAgenda);
		} catch (SQLException | EntityNotFoundException e) {
			System.out.println("Erro ao carregar o painel");
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
			cadastrarAgendaPanel.clearAgendaFields();
		}
	}
}
