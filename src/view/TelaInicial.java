package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JEditorPane;
import java.awt.CardLayout;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;

public class TelaInicial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
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
	public TelaInicial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(183, 208, 244));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 980, 700);
		panel.setBackground(new Color(249, 249, 249));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.setBackground(new Color(100, 124, 158));
		btnPacientes.setForeground(new Color(244, 244, 244));
		btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPacientes.setBounds(10, 10, 220, 200);
		panel.add(btnPacientes);
		
		JButton btnControle = new JButton("Controle");
		btnControle.setForeground(new Color(244, 244, 244));
		btnControle.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnControle.setBackground(new Color(100, 124, 158));
		btnControle.setBounds(258, 10, 220, 200);
		panel.add(btnControle);
		
		JButton btnEco = new JButton("Ecocardiograma");
		btnEco.setForeground(new Color(244, 244, 244));
		btnEco.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEco.setBackground(new Color(100, 124, 158));
		btnEco.setBounds(10, 251, 220, 200);
		panel.add(btnEco);
		
		JButton btnEletro = new JButton("Eletrocardiograma");
		btnEletro.setForeground(new Color(244, 244, 244));
		btnEletro.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEletro.setBackground(new Color(100, 124, 158));
		btnEletro.setBounds(258, 251, 220, 200);
		panel.add(btnEletro);
		
		JButton btnHolter = new JButton("Holter");
		btnHolter.setForeground(new Color(244, 244, 244));
		btnHolter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHolter.setBackground(new Color(100, 124, 158));
		btnHolter.setBounds(498, 251, 220, 200);
		panel.add(btnHolter);
		
		JButton btnErgo = new JButton("Teste Ergometrico");
		btnErgo.setForeground(new Color(244, 244, 244));
		btnErgo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnErgo.setBackground(new Color(100, 124, 158));
		btnErgo.setBounds(750, 251, 220, 200);
		panel.add(btnErgo);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(244, 244, 244));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSair.setBackground(new Color(100, 124, 158));
		btnSair.setBounds(750, 490, 220, 200);
		panel.add(btnSair);
		
		JButton btnBackup = new JButton("Backup");
		btnBackup.setForeground(new Color(244, 244, 244));
		btnBackup.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBackup.setBackground(new Color(100, 124, 158));
		btnBackup.setBounds(750, 10, 220, 200);
		panel.add(btnBackup);
		
		JButton btnControle_1 = new JButton("Controle");
		btnControle_1.setForeground(new Color(244, 244, 244));
		btnControle_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnControle_1.setBackground(new Color(100, 124, 158));
		btnControle_1.setBounds(10, 10, 220, 200);
		panel.add(btnControle_1);
		frame.setBackground(new Color(183, 208, 244));
		frame.setBounds(100, 100, 1024, 760);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
