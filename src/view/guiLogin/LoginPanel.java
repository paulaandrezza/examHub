package view.guiLogin;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import view.guiMenu.MenuPanel;

public class LoginPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textEmail;
	private JPasswordField passwordSenha;

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
					LoginPanel frame = new LoginPanel();
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
	public LoginPanel() {
		setTitle("ExamHub - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		Component login_vertical_glue_1 = Box.createVerticalGlue();
		contentPane.add(login_vertical_glue_1);

		JPanel panelEmail = new JPanel();
		contentPane.add(panelEmail);
		panelEmail.setLayout(new BoxLayout(panelEmail, BoxLayout.X_AXIS));

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		panelEmail.add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		textEmail.setColumns(20);
		textEmail.setMaximumSize(textEmail.getPreferredSize()); // Definindo o tamanho máximo
		panelEmail.add(textEmail);

		Component login_vertical_1 = Box.createVerticalStrut(16);
		contentPane.add(login_vertical_1);

		JPanel panelSenha = new JPanel();
		contentPane.add(panelSenha);
		panelSenha.setLayout(new BoxLayout(panelSenha, BoxLayout.X_AXIS));

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Verdana", Font.PLAIN, 14));
		panelSenha.add(lblSenha);

		passwordSenha = new JPasswordField();
		passwordSenha.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordSenha.setColumns(20);
		passwordSenha.setMaximumSize(passwordSenha.getPreferredSize()); // Definindo o tamanho máximo
		panelSenha.add(passwordSenha);

		Component login_vertical_2 = Box.createVerticalStrut(32);
		contentPane.add(login_vertical_2);

		Box horizontalBox = Box.createHorizontalBox();
		contentPane.add(horizontalBox);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				javax.swing.SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						MenuPanel tela = new MenuPanel();
						tela.setVisible(true);
					}
				});
				dispose();
			}
		});

		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 14));
		horizontalBox.add(btnLogin);

		Component login_vertical_glue_2 = Box.createVerticalGlue();
		getContentPane().add(login_vertical_glue_2);
	}
}
