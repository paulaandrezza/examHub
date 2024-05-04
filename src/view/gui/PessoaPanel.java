package view.gui;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.enums.EnumGenero;

public class PessoaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textField;
	private JTextField textCelular;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;

	/**
	 * Create the panel.
	 */
	public PessoaPanel() {
		setBackground(UIManager.getColor("menu"));
		setLayout(null);

		Box pessoaTitulo = Box.createVerticalBox();
		pessoaTitulo.setBounds(10, 10, 750, 45);
		add(pessoaTitulo);

		JLabel lblPessoaTitulo = new JLabel("DADOS PESSOAIS");
		pessoaTitulo.add(lblPessoaTitulo);
		lblPessoaTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPessoaTitulo.setFont(new Font("Verdana", Font.BOLD, 32));

		JSeparator hr = new JSeparator();
		pessoaTitulo.add(hr);

		Box nomeBox = Box.createHorizontalBox();
		nomeBox.setBounds(10, 65, 750, 32);
		add(nomeBox);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Verdana", Font.BOLD, 16));
		nomeBox.add(lblNome);

		Component horizontalStrut_1 = Box.createHorizontalStrut(8);
		nomeBox.add(horizontalStrut_1);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNome.setColumns(30);
		nomeBox.add(textFieldNome);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 97, 750, 32);
		add(horizontalStrut);

		Box documentoTitulo = Box.createVerticalBox();
		documentoTitulo.setBounds(10, 129, 750, 45);
		add(documentoTitulo);

		JLabel lblDocumentos = new JLabel("DOCUMENTOS");
		lblDocumentos.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocumentos.setFont(new Font("Verdana", Font.BOLD, 32));
		documentoTitulo.add(lblDocumentos);

		JSeparator hr_1 = new JSeparator();
		documentoTitulo.add(hr_1);

		Box documentosBox = Box.createHorizontalBox();
		documentosBox.setBounds(10, 177, 750, 32);
		add(documentosBox);

		Box cpfBox = Box.createHorizontalBox();
		cpfBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		documentosBox.add(cpfBox);

		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Verdana", Font.BOLD, 16));
		cpfBox.add(lblCPF);

		Component horizontalStrut_2 = Box.createHorizontalStrut(8);
		cpfBox.add(horizontalStrut_2);

		textFieldCPF = new JTextField();
		textFieldCPF.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldCPF.setColumns(10);
		cpfBox.add(textFieldCPF);

		Component horizontalStrut_2_1 = Box.createHorizontalStrut(32);
		cpfBox.add(horizontalStrut_2_1);

		Box rgBox = Box.createHorizontalBox();
		rgBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		documentosBox.add(rgBox);

		JLabel lblRG = new JLabel("RG:");
		lblRG.setFont(new Font("Verdana", Font.BOLD, 16));
		rgBox.add(lblRG);

		Component horizontalStrut_3 = Box.createHorizontalStrut(8);
		rgBox.add(horizontalStrut_3);

		textFieldRG = new JTextField();
		textFieldRG.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldRG.setColumns(10);
		rgBox.add(textFieldRG);

		Box dataNascimentoBox = Box.createHorizontalBox();
		nomeBox.add(dataNascimentoBox);

		Component horizontalStrut_2_1_1 = Box.createHorizontalStrut(32);
		dataNascimentoBox.add(horizontalStrut_2_1_1);

		JLabel lblDataNascimento = new JLabel("Data de nascimento:");
		lblDataNascimento.setFont(new Font("Verdana", Font.BOLD, 16));
		dataNascimentoBox.add(lblDataNascimento);

		Component horizontalStrut_3_1 = Box.createHorizontalStrut(8);
		dataNascimentoBox.add(horizontalStrut_3_1);

		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 12));
		textField.setColumns(10);
		dataNascimentoBox.add(textField);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4.setBounds(10, 209, 750, 32);
		add(horizontalStrut_4);

		Box contatoTitulo = Box.createVerticalBox();
		contatoTitulo.setBounds(10, 241, 750, 45);
		add(contatoTitulo);

		JLabel lblContato = new JLabel("CONTATO");
		lblContato.setHorizontalAlignment(SwingConstants.LEFT);
		lblContato.setFont(new Font("Verdana", Font.BOLD, 32));
		contatoTitulo.add(lblContato);

		JSeparator hr_1_1 = new JSeparator();
		contatoTitulo.add(hr_1_1);

		Box contatoBox = Box.createVerticalBox();
		contatoBox.setBounds(10, 289, 750, 128);
		add(contatoBox);

		Box celularBox = Box.createHorizontalBox();
		celularBox.setAlignmentY(0.5f);
		contatoBox.add(celularBox);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Verdana", Font.BOLD, 16));
		celularBox.add(lblCelular);

		Component horizontalStrut_2_2 = Box.createHorizontalStrut(8);
		celularBox.add(horizontalStrut_2_2);

		textCelular = new JTextField();
		textCelular.setFont(new Font("Verdana", Font.PLAIN, 12));
		textCelular.setColumns(10);
		celularBox.add(textCelular);

		Component verticalStrut = Box.createVerticalStrut(16);
		contatoBox.add(verticalStrut);

		Box telefoneBox = Box.createHorizontalBox();
		telefoneBox.setAlignmentY(0.5f);
		contatoBox.add(telefoneBox);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Verdana", Font.BOLD, 16));
		telefoneBox.add(lblTelefone);

		Component horizontalStrut_3_2 = Box.createHorizontalStrut(8);
		telefoneBox.add(horizontalStrut_3_2);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldTelefone.setColumns(10);
		telefoneBox.add(textFieldTelefone);

		Component verticalStrut_1 = Box.createVerticalStrut(16);
		contatoBox.add(verticalStrut_1);

		Box emailBox = Box.createHorizontalBox();
		contatoBox.add(emailBox);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 16));
		emailBox.add(lblEmail);

		Component horizontalStrut_3_1_1 = Box.createHorizontalStrut(8);
		emailBox.add(horizontalStrut_3_1_1);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldEmail.setColumns(10);
		emailBox.add(textFieldEmail);

		Component horizontalStrut_4_1 = Box.createHorizontalStrut(20);
		horizontalStrut_4_1.setBounds(10, 419, 750, 32);
		add(horizontalStrut_4_1);

		Box outrosTitulo = Box.createVerticalBox();
		outrosTitulo.setBounds(10, 451, 750, 45);
		add(outrosTitulo);

		JLabel lblOutros = new JLabel("OUTRAS INFORMAÇÕES");
		lblOutros.setHorizontalAlignment(SwingConstants.LEFT);
		lblOutros.setFont(new Font("Verdana", Font.BOLD, 32));
		outrosTitulo.add(lblOutros);

		JSeparator hr_1_1_1 = new JSeparator();
		outrosTitulo.add(hr_1_1_1);

		Box generoBox = Box.createHorizontalBox();
		generoBox.setAlignmentY(0.5f);
		generoBox.setBounds(10, 499, 750, 32);
		add(generoBox);

		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setFont(new Font("Verdana", Font.BOLD, 16));
		generoBox.add(lblGenero);

		Component horizontalStrut_2_2_1 = Box.createHorizontalStrut(8);
		generoBox.add(horizontalStrut_2_2_1);

		JComboBox comboBoxGenero = new JComboBox();
		comboBoxGenero.setModel(new DefaultComboBoxModel(EnumGenero.values()));
		comboBoxGenero.setSelectedIndex(0);
		generoBox.add(comboBoxGenero);

		Box acaoBox = Box.createHorizontalBox();
		acaoBox.setAlignmentY(0.5f);
		acaoBox.setBounds(605, 570, 154, 32);
		add(acaoBox);

		JButton btnCancelar = new JButton("Cancelar");
		acaoBox.add(btnCancelar);

		Component horizontalStrut_5 = Box.createHorizontalStrut(8);
		acaoBox.add(horizontalStrut_5);

		JButton btnProximo_1 = new JButton("Próximo");
		acaoBox.add(btnProximo_1);

	}
}
