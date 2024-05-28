package view.guiCadastro;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import controller.PacienteController;
import model.persistence.dao.paciente.PacienteFullDTO;
import service.Address;
import view.utils.ViaCep;

public class EnderecoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFormattedTextField textCep;
	private JTextField textEstado;
	private JTextField textCidade;
	private JTextField textBairro;
	private JTextField textRua;
	private JTextField textNumero;
	private JTextField textComplemento;

	/**
	 * Create the panel.
	 */

	public void clearEnderecoFields() {
		textCep.setText("");
		textEstado.setText("");
		textCidade.setText("");
		textBairro.setText("");
		textRua.setText("");
		textNumero.setText("");
		textComplemento.setText("");
	}

	public EnderecoPanel(PacienteController pacienteController, PacienteFullDTO pacienteFullDTO,
			CadastroPanel cadastroPanel) {
		setBackground(UIManager.getColor("menu"));
		setLayout(null);

		Box tituloBoxVerticalEndereco = Box.createVerticalBox();
		tituloBoxVerticalEndereco.setBounds(10, 10, 750, 45);
		add(tituloBoxVerticalEndereco);

		JLabel labelEnderecoTitulo = new JLabel("ENDEREÇO");
		tituloBoxVerticalEndereco.add(labelEnderecoTitulo);
		labelEnderecoTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelEnderecoTitulo.setFont(new Font("Verdana", Font.BOLD, 32));

		JSeparator hr_endereco_1 = new JSeparator();
		tituloBoxVerticalEndereco.add(hr_endereco_1);

		Box boxVerticalEndereco = Box.createVerticalBox();
		boxVerticalEndereco.setBounds(10, 65, 750, 350);
		add(boxVerticalEndereco);

		Box boxHorizontalCep = Box.createHorizontalBox();
		boxVerticalEndereco.add(boxHorizontalCep);

		JLabel labelCep = new JLabel("CEP:");
		labelCep.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCep.add(labelCep);

		JLabel labelInfo_1 = new JLabel("*");
		labelInfo_1.setForeground(Color.RED);
		labelInfo_1.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCep.add(labelInfo_1);

		Component horizontal_endereco_1 = Box.createHorizontalStrut(8);
		boxHorizontalCep.add(horizontal_endereco_1);

		try {
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			textCep = new JFormattedTextField(mascaraCep);
			textCep.setFont(new Font("Verdana", Font.PLAIN, 12));
			boxHorizontalCep.add(textCep);

			JButton btnProcurarCep = new JButton("Consultar CEP");
			btnProcurarCep.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnProcurarCep.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ViaCep viaCep = new ViaCep();
						Address local = viaCep.searchCep(textCep.getText());
						textEstado.setText(local.getEstado());
						textCidade.setText(local.getCidade());
						textBairro.setText(local.getBairro());
						textRua.setText(local.getLogradouro());
					} catch (Exception f) {
						System.out.println("Erro ao inserir os dados nos campos: " + f.getMessage());
					}
				}
			});

			boxHorizontalCep.add(btnProcurarCep);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Component vertical_endereco_1 = Box.createVerticalStrut(32);
		boxVerticalEndereco.add(vertical_endereco_1);

		Box boxHorizontalEstado = Box.createHorizontalBox();
		boxHorizontalEstado.setEnabled(false);
		boxHorizontalEstado.setEnabled(false);
		boxHorizontalEstado.setBounds(0, 0, 750, 32);
		boxVerticalEndereco.add(boxHorizontalEstado);

		JLabel labelEstado = new JLabel("Estado:");
		labelEstado.setEnabled(false);
		labelEstado.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalEstado.add(labelEstado);

		JLabel labelInfo_2 = new JLabel("*");
		labelInfo_2.setEnabled(false);
		labelInfo_2.setForeground(Color.RED);
		labelInfo_2.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalEstado.add(labelInfo_2);

		Component horizontal_endereco_2 = Box.createHorizontalStrut(8);
		boxHorizontalEstado.add(horizontal_endereco_2);

		textEstado = new JTextField();
		textEstado.setEditable(false);
		textEstado.setFont(new Font("Verdana", Font.PLAIN, 12));
		textEstado.setColumns(10);
		boxHorizontalEstado.add(textEstado);

		Component vertical_endereco_2 = Box.createVerticalStrut(32);
		boxVerticalEndereco.add(vertical_endereco_2);

		Box boxHorizontalCidade = Box.createHorizontalBox();
		boxHorizontalCidade.setEnabled(false);
		boxHorizontalCidade.setEnabled(false);
		boxHorizontalCidade.setBounds(0, 0, 750, 96);
		boxVerticalEndereco.add(boxHorizontalCidade);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setEnabled(false);
		lblCidade.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCidade.add(lblCidade);

		JLabel labelInfo_3 = new JLabel("*");
		labelInfo_3.setEnabled(false);
		labelInfo_3.setForeground(Color.RED);
		labelInfo_3.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCidade.add(labelInfo_3);

		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(8);
		boxHorizontalCidade.add(horizontalStrut_1_1_1);

		textCidade = new JTextField();
		textCidade.setEditable(false);
		textCidade.setFont(new Font("Verdana", Font.PLAIN, 12));
		textCidade.setColumns(10);
		boxHorizontalCidade.add(textCidade);

		Component vertical_endereco_3 = Box.createVerticalStrut(32);
		boxVerticalEndereco.add(vertical_endereco_3);

		Box boxHorizontalLogradouro = Box.createHorizontalBox();
		boxVerticalEndereco.add(boxHorizontalLogradouro);

		Box bairroBox = Box.createHorizontalBox();
		boxVerticalEndereco.add(bairroBox);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Verdana", Font.BOLD, 16));
		bairroBox.add(lblBairro);

		JLabel labelInfo_4 = new JLabel("*");
		labelInfo_4.setForeground(Color.RED);
		labelInfo_4.setFont(new Font("Verdana", Font.BOLD, 16));
		bairroBox.add(labelInfo_4);

		Component horizontalStrut_1_1_1_1 = Box.createHorizontalStrut(8);
		bairroBox.add(horizontalStrut_1_1_1_1);

		textBairro = new JTextField();
		textBairro.setFont(new Font("Verdana", Font.PLAIN, 12));
		textBairro.setColumns(10);
		bairroBox.add(textBairro);

		Component vertical_endereco_4 = Box.createVerticalStrut(32);
		boxVerticalEndereco.add(vertical_endereco_4);

		Box ruaBox = Box.createHorizontalBox();
		ruaBox.setBounds(0, 0, 750, 48);
		boxVerticalEndereco.add(ruaBox);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Verdana", Font.BOLD, 16));
		ruaBox.add(lblRua);

		JLabel labelInfo_5 = new JLabel("*");
		labelInfo_5.setForeground(Color.RED);
		labelInfo_5.setFont(new Font("Verdana", Font.BOLD, 16));
		ruaBox.add(labelInfo_5);

		Component horizontalStrut_1_1_1_1_1 = Box.createHorizontalStrut(8);
		ruaBox.add(horizontalStrut_1_1_1_1_1);

		textRua = new JTextField();
		textRua.setFont(new Font("Verdana", Font.PLAIN, 12));
		textRua.setColumns(10);
		ruaBox.add(textRua);

		Component vertical_endereco_5 = Box.createVerticalStrut(32);
		boxVerticalEndereco.add(vertical_endereco_5);

		Box boxHorizontalLocalizacao = Box.createHorizontalBox();
		boxHorizontalLocalizacao.setBounds(0, 0, 1, 1);
		boxVerticalEndereco.add(boxHorizontalLocalizacao);

		Box boxHorizontalNumero = Box.createHorizontalBox();
		boxHorizontalLocalizacao.add(boxHorizontalNumero);

		JLabel labelNumero = new JLabel("Número:");
		labelNumero.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalNumero.add(labelNumero);

		Component horizontal_endereco_3 = Box.createHorizontalStrut(8);
		boxHorizontalNumero.add(horizontal_endereco_3);

		textNumero = new JTextField();
		textNumero.setFont(new Font("Verdana", Font.PLAIN, 12));
		textNumero.setColumns(1);
		boxHorizontalNumero.add(textNumero);

		Component horizontal_endereco_4 = Box.createHorizontalStrut(32);
		boxHorizontalLocalizacao.add(horizontal_endereco_4);

		Box boxHorizontalComplemento = Box.createHorizontalBox();
		boxHorizontalComplemento.setBounds(0, 0, 750, 32);
		boxHorizontalLocalizacao.add(boxHorizontalComplemento);

		JLabel labelComplemento = new JLabel("Complemento:");
		labelComplemento.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalComplemento.add(labelComplemento);

		Component horizontal_endereco_5 = Box.createHorizontalStrut(8);
		boxHorizontalComplemento.add(horizontal_endereco_5);

		textComplemento = new JTextField();
		textComplemento.setFont(new Font("Verdana", Font.PLAIN, 12));
		textComplemento.setColumns(10);
		boxHorizontalComplemento.add(textComplemento);

		Box boxHorizontalAcao = Box.createHorizontalBox();
		boxHorizontalAcao.setAlignmentY(0.5f);
		boxHorizontalAcao.setBounds(10, 570, 750, 32);
		add(boxHorizontalAcao);

		Box boxHorizontalVoltar = Box.createHorizontalBox();
		boxHorizontalAcao.add(boxHorizontalVoltar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroPanel.switchToBackTab();
			}
		});
		boxHorizontalVoltar.add(btnVoltar);

		Component horizontal_acao_1 = Box.createHorizontalStrut(500);
		boxHorizontalAcao.add(horizontal_acao_1);

		Box boxHorizontalCancelarEProximo = Box.createHorizontalBox();
		boxHorizontalAcao.add(boxHorizontalCancelarEProximo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroPanel.switchToCancelTab();
			}
		});
		boxHorizontalCancelarEProximo.add(btnCancelar);

		Component horizontal_acao_2 = Box.createHorizontalStrut(8);
		boxHorizontalCancelarEProximo.add(horizontal_acao_2);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cep = textCep.getText().replaceAll("[^0-9]", "");
					System.out.println(cep);
					pacienteFullDTO.setCep(Integer.parseInt(cep));
					pacienteFullDTO.setEstado(textEstado.getText());
					pacienteFullDTO.setCidade(textCidade.getText());
					pacienteFullDTO.setRua(textRua.getText());
					pacienteFullDTO.setBairro(textBairro.getText());

					if (textNumero.getText().equals("")) {
						pacienteFullDTO.setNumero(null);
					} else {
						pacienteFullDTO.setNumero(textNumero.getText());
					}

					if (textNumero.getText().equals("")) {
						pacienteFullDTO.setComplemento(null);
					} else {
						pacienteFullDTO.setComplemento(textComplemento.getText());
					}

					pacienteFullDTO.setCep(Integer.parseInt(textCep.getText()));
					pacienteFullDTO.setEstado(textEstado.getText());
					pacienteFullDTO.setCidade(textCidade.getText());
					pacienteFullDTO.setRua(textRua.getText());
					pacienteFullDTO.setBairro(textBairro.getText());

					if (textNumero.getText().equals("")) {
						pacienteFullDTO.setNumero(null);
					} else {
						pacienteFullDTO.setNumero(textNumero.getText());
					}

					if (textNumero.getText().equals("")) {
						pacienteFullDTO.setComplemento(null);
					} else {
						pacienteFullDTO.setComplemento(textComplemento.getText());
					}

					pacienteController.create(pacienteFullDTO);
				} catch (Exception a) {
					System.out.println("Error: " + a.getMessage());
				}
			}
		});
		boxHorizontalCancelarEProximo.add(btnCadastrar);

	}
}