package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class TelaLogin {

	private JFrame frame;
	private JTextField textUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(183, 208, 244));
		frame.setBackground(new Color(183, 208, 244));
		frame.setBounds(100, 100, 1360, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[300px][800px][300px]", "[100px][600px][100px]"));
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(249, 249, 249));
		frame.getContentPane().add(panelLogin, "cell 1 1,grow");
		panelLogin.setLayout(null);
		
		JLabel lblBemVindo = new JLabel("Bem-vindo!");
		lblBemVindo.setForeground(new Color(36, 38, 55));
		lblBemVindo.setBounds(330, 60, 140, 30);
		lblBemVindo.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelLogin.add(lblBemVindo);
		
		textUsuario = new JTextField();
		textUsuario.setForeground(new Color(178, 178, 178));
		textUsuario.setText("Digite seu usuário...");
		textUsuario.setBounds(160, 190, 500, 30);
		panelLogin.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuário");
		lblUsuario.setForeground(new Color(36, 38, 55));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(160, 165, 60, 14);
		panelLogin.add(lblUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 310, 500, 30);
		panelLogin.add(passwordField);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(36, 38, 55));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(165, 285, 60, 14);
		panelLogin.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEntrar.setForeground(new Color(244, 244, 244));
		btnEntrar.setBackground(new Color(100, 124, 158));
		btnEntrar.setBounds(330, 400, 150, 30);
		panelLogin.add(btnEntrar);
	}
}
