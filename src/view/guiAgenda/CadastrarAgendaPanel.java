package view.guiAgenda;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class CadastrarAgendaPanel extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarAgendaPanel frame = new CadastrarAgendaPanel();
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
	public CadastrarAgendaPanel() {
		setBounds(100, 100, 768, 811);

	}

}
