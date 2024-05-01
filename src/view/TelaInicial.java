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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;

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
		
		JPanel panelTelaInicial = new JPanel();
		panelTelaInicial.setBounds(10, 10, 1345, 685);
		panelTelaInicial.setBackground(new Color(249, 249, 249));
		frame.getContentPane().add(panelTelaInicial);
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.setBackground(new Color(100, 124, 158));
		btnPacientes.setForeground(new Color(244, 244, 244));
		btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelTelaInicial.setLayout(new MigLayout("", "[220px][220px][220px][220px][200px][220px]", "[10px][200px][100px][200px][50px][100px]"));
		panelTelaInicial.add(btnPacientes, "cell 0 1,grow");
		
		JButton btnBackup = new JButton("Backup");
		btnBackup.setForeground(new Color(244, 244, 244));
		btnBackup.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBackup.setBackground(new Color(100, 124, 158));
		panelTelaInicial.add(btnBackup, "cell 5 1,grow");
		
		JButton btnEco = new JButton("Ecocardiograma");
		btnEco.setForeground(new Color(244, 244, 244));
		btnEco.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEco.setBackground(new Color(100, 124, 158));
		panelTelaInicial.add(btnEco, "cell 1 3,grow");
		
		JButton btnEletro = new JButton("Eletrocardiograma");
		btnEletro.setForeground(new Color(244, 244, 244));
		btnEletro.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEletro.setBackground(new Color(100, 124, 158));
		panelTelaInicial.add(btnEletro, "cell 2 3,grow");
		
		JButton btnHolter = new JButton("Holter");
		btnHolter.setForeground(new Color(244, 244, 244));
		btnHolter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHolter.setBackground(new Color(100, 124, 158));
		panelTelaInicial.add(btnHolter, "cell 3 3,grow");
		
		JButton btnErgo = new JButton("Teste Ergometrico");
		btnErgo.setForeground(new Color(244, 244, 244));
		btnErgo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnErgo.setBackground(new Color(100, 124, 158));
		panelTelaInicial.add(btnErgo, "cell 4 3,grow");
		
		JButton btnSair = new JButton("Sair");
		btnSair.setForeground(new Color(244, 244, 244));
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSair.setBackground(new Color(233, 82, 82));
		panelTelaInicial.add(btnSair, "cell 5 5,grow");
		frame.setBackground(new Color(183, 208, 244));
		frame.setBounds(100, 100, 1360, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
