package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroPaciente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCodPaciente;
	private JTextField textFieldNomePaciente;
	private JLabel lblDataNascimento;
	private JTextField textFieldDataNascimento;
	private JLabel lblRG;
	private JTextField textFieldRG;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;
	private JTextField textFieldConvenio;
	private JTextField textFieldTelefone;
	private JTextField textField;
	private JButton btnConfirmar;
	private JButton btnLimpr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
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
	public TelaCadastroPaciente() {
		setResizable(false);
		setTitle("Cadastro de pacientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodCliente = new JLabel("Código Paciente");
		lblCodCliente.setBounds(28, 33, 124, 14);
		contentPane.add(lblCodCliente);
		
		textFieldCodPaciente = new JTextField();
		textFieldCodPaciente.setBounds(137, 30, 148, 20);
		contentPane.add(textFieldCodPaciente);
		textFieldCodPaciente.setColumns(10);
		
		JLabel lblNomePaciente = new JLabel("Nome Paciente");
		lblNomePaciente.setBounds(28, 71, 107, 14);
		contentPane.add(lblNomePaciente);
		
		textFieldNomePaciente = new JTextField();
		textFieldNomePaciente.setColumns(10);
		textFieldNomePaciente.setBounds(137, 68, 388, 20);
		contentPane.add(textFieldNomePaciente);
		
		lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setBounds(28, 110, 101, 14);
		contentPane.add(lblDataNascimento);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(137, 107, 73, 20);
		contentPane.add(textFieldDataNascimento);
		
		lblRG = new JLabel("RG");
		lblRG.setBounds(235, 110, 23, 14);
		contentPane.add(lblRG);
		
		textFieldRG = new JTextField();
		textFieldRG.setColumns(10);
		textFieldRG.setBounds(255, 107, 124, 20);
		contentPane.add(textFieldRG);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(405, 110, 29, 14);
		contentPane.add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(439, 107, 86, 20);
		contentPane.add(textFieldPeso);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(28, 144, 40, 14);
		contentPane.add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setColumns(10);
		textFieldAltura.setBounds(66, 141, 86, 20);
		contentPane.add(textFieldAltura);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(170, 144, 40, 14);
		contentPane.add(lblSexo);
		
		JLabel lblConvenio = new JLabel("Convênio");
		lblConvenio.setBounds(314, 144, 59, 14);
		contentPane.add(lblConvenio);
		
		textFieldConvenio = new JTextField();
		textFieldConvenio.setColumns(10);
		textFieldConvenio.setBounds(377, 142, 86, 20);
		contentPane.add(textFieldConvenio);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(28, 186, 59, 14);
		contentPane.add(lblTelefone);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(84, 183, 86, 20);
		contentPane.add(textFieldTelefone);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino", "Não Binário", "Outros"}));
		comboBoxSexo.setBounds(209, 140, 95, 22);
		contentPane.add(comboBoxSexo);
		
		JLabel lblCel = new JLabel("Cel");
		lblCel.setBounds(194, 186, 45, 14);
		contentPane.add(lblCel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(219, 183, 86, 20);
		contentPane.add(textField);
		
		JLabel lblExame = new JLabel("Exame");
		lblExame.setBounds(333, 186, 40, 14);
		contentPane.add(lblExame);
		
		JComboBox comboBoxExame = new JComboBox();
		comboBoxExame.setModel(new DefaultComboBoxModel(new String[] {"Eletrocardiografia", "Ecocardiografia", "Holter 24h", "Teste Ergométrico"}));
		comboBoxExame.setBounds(387, 182, 124, 22);
		contentPane.add(comboBoxExame);
		
		JButton btnVoltar = new JButton("Cancelar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBounds(20, 393, 89, 23);
		contentPane.add(btnVoltar);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(427, 393, 115, 23);
		contentPane.add(btnConfirmar);
		
		btnLimpr = new JButton("Limpar");
		btnLimpr.setBounds(119, 393, 89, 23);
		contentPane.add(btnLimpr);
	}
}
