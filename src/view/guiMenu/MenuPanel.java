package view.guiMenu;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import view.guiPaciente.CadastroPanel;

public class MenuPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPanelMenuWindow = new JDesktopPane();
	private JInternalFrame currentInternalFrame;
	private JPanel panelMenuLista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPanel frame = new MenuPanel();
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
	public MenuPanel() {
		getContentPane().setBackground(SystemColor.menu);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ExamHub - Cadastro e Agendamento de Pacientes");
		setBounds(100, 100, 782, 472);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		panelMenuLista = new JPanel();
		panelMenuLista.setAlignmentY(Component.TOP_ALIGNMENT);
		panelMenuLista.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelMenuLista.setBackground(SystemColor.menu);
		panelMenuLista.setLayout(new BoxLayout(panelMenuLista, BoxLayout.Y_AXIS));

		JScrollPane scrollMenuLista = new JScrollPane(panelMenuLista);
		scrollMenuLista.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollMenuLista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMenuLista.setMaximumSize(new java.awt.Dimension(800, Integer.MAX_VALUE));

		Box boxVerticalMenuTitulo = Box.createVerticalBox();
		panelMenuLista.add(boxVerticalMenuTitulo);

		JLabel titleLabel = new JLabel("ExamHub");
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		titleLabel.setAlignmentX(0.5f);
		boxVerticalMenuTitulo.add(titleLabel);

		JSeparator hr_endereco_1 = new JSeparator();
		boxVerticalMenuTitulo.add(hr_endereco_1);

		Component vertical_menu_1 = Box.createVerticalStrut(32);
		boxVerticalMenuTitulo.add(vertical_menu_1);

		addMenuItem(panelMenuLista, "Cadastrar Novo Paciente", e -> openInternalFrame(new CadastroPanel()));

		desktopPanelMenuWindow.setBackground(SystemColor.activeCaption);
		desktopPanelMenuWindow.setMaximumSize(new java.awt.Dimension(800, Integer.MAX_VALUE));

		Box box = Box.createHorizontalBox();
		box.add(scrollMenuLista);
		box.add(desktopPanelMenuWindow);
		getContentPane().add(box);
	}

	private void addMenuItem(JPanel panel, String label, ActionListener actionListener) {
		Box boxHorizontal = Box.createHorizontalBox();
		boxHorizontal.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.add(boxHorizontal);

		JLabel itemLabel = DefaultComponentFactory.getInstance().createLabel(label);
		itemLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		itemLabel.setHorizontalAlignment(SwingConstants.LEFT);
		itemLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		boxHorizontal.add(itemLabel);

		JButton btnOpen = new JButton("Abrir");
		btnOpen.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnOpen.addActionListener(actionListener);

		Component horizontalGlue = Box.createHorizontalGlue();
		boxHorizontal.add(horizontalGlue);
		boxHorizontal.add(btnOpen);

		Component vertical_menu_2 = Box.createVerticalStrut(16);
		panelMenuLista.add(vertical_menu_2);
	}

	private void openInternalFrame(JInternalFrame internalFrame) {
		if (currentInternalFrame != null && !currentInternalFrame.isClosed()) {
			try {
				currentInternalFrame.setClosed(true);
			} catch (java.beans.PropertyVetoException e) {
				e.printStackTrace();
			}
		}
		internalFrame.setVisible(true);
		desktopPanelMenuWindow.add(internalFrame);
		try {
			internalFrame.setMaximum(true);
		} catch (java.beans.PropertyVetoException e) {
			e.printStackTrace();
		}
		currentInternalFrame = internalFrame;
	}
}
