package view.gui;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class EnderecoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldCep;
	private JTextField textFieldEstado;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldComplemento;

	/**
	 * Create the panel.
	 */
	public EnderecoPanel() {
		setBackground(UIManager.getColor("menu"));
		setLayout(null);

		Box enderecoTitulo = Box.createVerticalBox();
		enderecoTitulo.setBounds(10, 10, 750, 45);
		add(enderecoTitulo);

		JLabel lblEnderecoTitulo = new JLabel("ENDEREÇO");
		enderecoTitulo.add(lblEnderecoTitulo);
		lblEnderecoTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoTitulo.setFont(new Font("Verdana", Font.BOLD, 32));

		JSeparator hr = new JSeparator();
		enderecoTitulo.add(hr);

		Box enderecoBox = Box.createVerticalBox();
		enderecoBox.setBounds(10, 65, 750, 272);
		add(enderecoBox);

		Box cepBox = Box.createHorizontalBox();
		enderecoBox.add(cepBox);

		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Verdana", Font.BOLD, 16));
		cepBox.add(lblCep);

		Component horizontalStrut_1 = Box.createHorizontalStrut(8);
		cepBox.add(horizontalStrut_1);

		textFieldCep = new JTextField();
		textFieldCep.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldCep.setColumns(10);
		cepBox.add(textFieldCep);

		Component verticalStrut = Box.createVerticalStrut(16);
		enderecoBox.add(verticalStrut);

		Box estadoBox = Box.createHorizontalBox();
		estadoBox.setBounds(0, 0, 750, 32);
		enderecoBox.add(estadoBox);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Verdana", Font.BOLD, 16));
		estadoBox.add(lblEstado);

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(8);
		estadoBox.add(horizontalStrut_1_1);

		textFieldEstado = new JTextField();
		textFieldEstado.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldEstado.setColumns(10);
		estadoBox.add(textFieldEstado);

		Component verticalStrut_1 = Box.createVerticalStrut(16);
		enderecoBox.add(verticalStrut_1);

		Box cidadeBox = Box.createHorizontalBox();
		cidadeBox.setBounds(0, 0, 750, 96);
		enderecoBox.add(cidadeBox);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Verdana", Font.BOLD, 16));
		cidadeBox.add(lblCidade);

		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(8);
		cidadeBox.add(horizontalStrut_1_1_1);

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldCidade.setColumns(10);
		cidadeBox.add(textFieldCidade);

		Component verticalStrut_2 = Box.createVerticalStrut(16);
		enderecoBox.add(verticalStrut_2);

		Box logradouroBox = Box.createHorizontalBox();
		enderecoBox.add(logradouroBox);

		Box bairroBox = Box.createHorizontalBox();
		logradouroBox.add(bairroBox);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 16));
		bairroBox.add(lblBairro);

		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(8);
		bairroBox.add(horizontalStrut_1_1_1_1);

		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldBairro.setColumns(10);
		bairroBox.add(textFieldBairro);

		Component verticalStrut_3 = Box.createVerticalStrut(16);
		enderecoBox.add(verticalStrut_3);

		Component horizontalStrut_2 = Box.createHorizontalStrut(32);
		logradouroBox.add(horizontalStrut_2);

		Box ruaBox = Box.createHorizontalBox();
		ruaBox.setBounds(0, 0, 750, 48);
		logradouroBox.add(ruaBox);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Verdana", Font.BOLD, 16));
		ruaBox.add(lblRua);

		Component horizontalStrut_1_1_1_1_1 = Box.createHorizontalStrut(8);
		ruaBox.add(horizontalStrut_1_1_1_1_1);

		textFieldRua = new JTextField();
		textFieldRua.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldRua.setColumns(10);
		ruaBox.add(textFieldRua);

		Component verticalStrut_4 = Box.createVerticalStrut(16);
		enderecoBox.add(verticalStrut_4);

		Box casaBox = Box.createHorizontalBox();
		casaBox.setBounds(0, 0, 1, 1);
		enderecoBox.add(casaBox);

		Box numeroBox = Box.createHorizontalBox();
		casaBox.add(numeroBox);

		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("Verdana", Font.BOLD, 16));
		numeroBox.add(lblNumero);

		Component horizontalStrut_1_1_1_1_1_1 = Box.createHorizontalStrut(8);
		numeroBox.add(horizontalStrut_1_1_1_1_1_1);

		textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNumero.setColumns(1);
		numeroBox.add(textFieldNumero);

		Component horizontalStrut = Box.createHorizontalStrut(32);
		casaBox.add(horizontalStrut);

		Box complementoBox = Box.createHorizontalBox();
		complementoBox.setBounds(0, 0, 750, 32);
		casaBox.add(complementoBox);

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Verdana", Font.BOLD, 16));
		complementoBox.add(lblComplemento);

		Component horizontalStrut_1_1_1_1_1_1_1 = Box.createHorizontalStrut(8);
		complementoBox.add(horizontalStrut_1_1_1_1_1_1_1);

		textFieldComplemento = new JTextField();
		textFieldComplemento.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldComplemento.setColumns(10);
		complementoBox.add(textFieldComplemento);

		Box acaoBox = Box.createHorizontalBox();
		acaoBox.setAlignmentY(0.5f);
		acaoBox.setBounds(595, 570, 165, 32);
		add(acaoBox);

		JButton btnCancelar = new JButton("Cancelar");
		acaoBox.add(btnCancelar);

		Component horizontalStrut_5 = Box.createHorizontalStrut(8);
		acaoBox.add(horizontalStrut_5);

		JButton btnCadastrar = new JButton("Cadastrar");
		acaoBox.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 570, 75, 28);
		add(btnVoltar);

	}
}
