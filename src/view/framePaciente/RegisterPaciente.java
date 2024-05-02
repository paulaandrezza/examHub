package view.framePaciente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class RegisterPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pacienteAltura;
	private JLabel fumanteLabel;
	private JRadioButton fumanteYesRadioBtn;
	private JRadioButton fumanteNoRadioBtn;
	private final ButtonGroup fumanteGroup = new ButtonGroup();
	private JLabel marcaPassoLabel;
	private JRadioButton marcaPassoYesRadioBtn;
	private JRadioButton marcaPassoNoRadioBtn;
	private final ButtonGroup marcaPassoGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPaciente frame = new RegisterPaciente();
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
	public RegisterPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Altura");
		contentPane.add(lblNewLabel);
		
		pacienteAltura = new JTextField();
		pacienteAltura.setToolTipText("");
		contentPane.add(pacienteAltura);
		pacienteAltura.setColumns(10);
		
		fumanteLabel = new JLabel("Fumante");
		contentPane.add(fumanteLabel);
		
		fumanteYesRadioBtn = new JRadioButton("Sim");
		fumanteGroup.add(fumanteYesRadioBtn);
		contentPane.add(fumanteYesRadioBtn);
		
		fumanteNoRadioBtn = new JRadioButton("Não");
		fumanteGroup.add(fumanteNoRadioBtn);
		contentPane.add(fumanteNoRadioBtn);
		
		marcaPassoLabel = new JLabel("Marca Passo");
		contentPane.add(marcaPassoLabel);
		
		marcaPassoYesRadioBtn = new JRadioButton("Sim");
		marcaPassoGroup.add(marcaPassoYesRadioBtn);
		contentPane.add(marcaPassoYesRadioBtn);
		
		marcaPassoNoRadioBtn = new JRadioButton("Não");
		marcaPassoGroup.add(marcaPassoNoRadioBtn);
		contentPane.add(marcaPassoNoRadioBtn);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
