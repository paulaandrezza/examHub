package view.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.enums.EnumGenero;
import model.persistence.dao.paciente.PacienteFullDTO;

public class PessoaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textRg;
	private JTextField textDataNascimento;
	private JTextField textCelular;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JComboBox<Object> comboBoxGenero = new JComboBox<Object>();

	/**
	 * Create the panel.
	 */
	public void clearPessoaFields() {
		textNome.setText("");
		textCpf.setText("");
		textRg.setText("");
		textDataNascimento.setText("");
		textCelular.setText("");
		textTelefone.setText("");
		textEmail.setText("");
		comboBoxGenero.setSelectedIndex(0);
	}

	public PessoaPanel(PacienteFullDTO pacienteFullDTO, CadastroPanel cadastroPanel) {
		setBackground(UIManager.getColor("menu"));
		setLayout(null);

		Box tituloBoxVerticalDadosPessoais = Box.createVerticalBox();
		tituloBoxVerticalDadosPessoais.setBounds(10, 10, 750, 45);
		add(tituloBoxVerticalDadosPessoais);

		JLabel tituloDadosPessoais = new JLabel("DADOS PESSOAIS");
		tituloBoxVerticalDadosPessoais.add(tituloDadosPessoais);
		tituloDadosPessoais.setHorizontalAlignment(SwingConstants.LEFT);
		tituloDadosPessoais.setFont(new Font("Verdana", Font.BOLD, 32));

		JSeparator hr_dadosPessoais = new JSeparator();
		tituloBoxVerticalDadosPessoais.add(hr_dadosPessoais);

		Box boxHorizontalDadosPessoais = Box.createHorizontalBox();
		boxHorizontalDadosPessoais.setBounds(10, 65, 750, 32);
		add(boxHorizontalDadosPessoais);

		Box boxHorizontalNome = Box.createHorizontalBox();
		boxHorizontalDadosPessoais.add(boxHorizontalNome);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalNome.add(labelNome);

		JLabel labelInfo_1 = new JLabel("*");
		labelInfo_1.setForeground(Color.RED);
		labelInfo_1.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalNome.add(labelInfo_1);

		Component horizontal_dadosPessoais_1 = Box.createHorizontalStrut(8);
		boxHorizontalNome.add(horizontal_dadosPessoais_1);

		textNome = new JTextField();
		textNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		textNome.setColumns(30);
		boxHorizontalNome.add(textNome);

		Component horizontal_pessoapanel_1 = Box.createHorizontalStrut(20);
		horizontal_pessoapanel_1.setBounds(10, 97, 750, 32);
		add(horizontal_pessoapanel_1);

		Box tituloBoxVerticalDocumentos = Box.createVerticalBox();
		tituloBoxVerticalDocumentos.setBounds(10, 129, 750, 45);
		add(tituloBoxVerticalDocumentos);

		JLabel documentosLabel = new JLabel("DOCUMENTOS");
		documentosLabel.setHorizontalAlignment(SwingConstants.LEFT);
		documentosLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalDocumentos.add(documentosLabel);

		JSeparator hr_documentos = new JSeparator();
		tituloBoxVerticalDocumentos.add(hr_documentos);

		Box boxHorizontalDocumentos = Box.createHorizontalBox();
		boxHorizontalDocumentos.setBounds(10, 177, 750, 32);
		add(boxHorizontalDocumentos);

		Box boxHorizontalCpf = Box.createHorizontalBox();
		boxHorizontalCpf.setAlignmentY(Component.CENTER_ALIGNMENT);
		boxHorizontalDocumentos.add(boxHorizontalCpf);

		JLabel labelCpf = new JLabel("CPF:");
		labelCpf.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCpf.add(labelCpf);

		JLabel labelInfo_3 = new JLabel("*");
		labelInfo_3.setForeground(Color.RED);
		labelInfo_3.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCpf.add(labelInfo_3);

		Component horizontal_documentos_1 = Box.createHorizontalStrut(8);
		boxHorizontalCpf.add(horizontal_documentos_1);

		textCpf = new JTextField();
		textCpf.setFont(new Font("Verdana", Font.PLAIN, 12));
		textCpf.setColumns(10);
		boxHorizontalCpf.add(textCpf);

		Component horizontal_documentos_2 = Box.createHorizontalStrut(32);
		boxHorizontalDocumentos.add(horizontal_documentos_2);

		Box boxHorizontalRg = Box.createHorizontalBox();
		boxHorizontalRg.setAlignmentY(Component.CENTER_ALIGNMENT);
		boxHorizontalDocumentos.add(boxHorizontalRg);

		JLabel labelRg = new JLabel("RG:");
		labelRg.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalRg.add(labelRg);

		JLabel labelInfo_4 = new JLabel("*");
		labelInfo_4.setForeground(Color.RED);
		labelInfo_4.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalRg.add(labelInfo_4);

		Component horizontal_documentos_3 = Box.createHorizontalStrut(8);
		boxHorizontalRg.add(horizontal_documentos_3);

		textRg = new JTextField();
		textRg.setFont(new Font("Verdana", Font.PLAIN, 12));
		textRg.setColumns(10);
		boxHorizontalRg.add(textRg);

		Component horizontal_dadosPessoais_2 = Box.createHorizontalStrut(32);
		boxHorizontalDadosPessoais.add(horizontal_dadosPessoais_2);

		Box boxHorizontalDataNascimento = Box.createHorizontalBox();
		boxHorizontalDadosPessoais.add(boxHorizontalDataNascimento);

		JLabel labelDataNascimento = new JLabel("Data de nascimento:");
		labelDataNascimento.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalDataNascimento.add(labelDataNascimento);

		JLabel labelInfo_2 = new JLabel("*");
		labelInfo_2.setForeground(Color.RED);
		labelInfo_2.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalDataNascimento.add(labelInfo_2);

		Component horizontal_dadosPessoais_3 = Box.createHorizontalStrut(8);
		boxHorizontalDataNascimento.add(horizontal_dadosPessoais_3);

		textDataNascimento = new JTextField();
		textDataNascimento.setFont(new Font("Verdana", Font.PLAIN, 12));
		textDataNascimento.setColumns(10);
		boxHorizontalDataNascimento.add(textDataNascimento);

		Component horizontal_pessoapanel_2 = Box.createHorizontalStrut(20);
		horizontal_pessoapanel_2.setBounds(10, 209, 750, 32);
		add(horizontal_pessoapanel_2);

		Box tituloBoxVerticalContato = Box.createVerticalBox();
		tituloBoxVerticalContato.setBounds(10, 241, 750, 45);
		add(tituloBoxVerticalContato);

		JLabel labelContato = new JLabel("CONTATO");
		labelContato.setHorizontalAlignment(SwingConstants.LEFT);
		labelContato.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalContato.add(labelContato);

		JSeparator hr_contato = new JSeparator();
		tituloBoxVerticalContato.add(hr_contato);

		Box boxVerticalContato = Box.createVerticalBox();
		boxVerticalContato.setBounds(10, 289, 750, 128);
		add(boxVerticalContato);

		Box boxHorizontalCelular = Box.createHorizontalBox();
		boxHorizontalCelular.setAlignmentY(0.5f);
		boxVerticalContato.add(boxHorizontalCelular);

		JLabel labelCelular = new JLabel("Celular:");
		labelCelular.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCelular.add(labelCelular);

		JLabel labelInfo_5 = new JLabel("*");
		labelInfo_5.setForeground(Color.RED);
		labelInfo_5.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCelular.add(labelInfo_5);

		Component horizontal_contato_1 = Box.createHorizontalStrut(8);
		boxHorizontalCelular.add(horizontal_contato_1);

		textCelular = new JTextField();
		textCelular.setFont(new Font("Verdana", Font.PLAIN, 12));
		textCelular.setColumns(10);
		boxHorizontalCelular.add(textCelular);

		Component vertical_contato_1 = Box.createVerticalStrut(16);
		boxVerticalContato.add(vertical_contato_1);

		Box boxHorizontalTelefone = Box.createHorizontalBox();
		boxHorizontalTelefone.setAlignmentY(0.5f);
		boxVerticalContato.add(boxHorizontalTelefone);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalTelefone.add(labelTelefone);

		Component horizontal_contato_2 = Box.createHorizontalStrut(8);
		boxHorizontalTelefone.add(horizontal_contato_2);

		textTelefone = new JTextField();
		textTelefone.setFont(new Font("Verdana", Font.PLAIN, 12));
		textTelefone.setColumns(10);
		boxHorizontalTelefone.add(textTelefone);

		Component vertical_contato_2 = Box.createVerticalStrut(16);
		boxVerticalContato.add(vertical_contato_2);

		Box boxHorizontalEmail = Box.createHorizontalBox();
		boxVerticalContato.add(boxHorizontalEmail);

		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalEmail.add(labelEmail);

		Component horizontal_contato_3 = Box.createHorizontalStrut(8);
		boxHorizontalEmail.add(horizontal_contato_3);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Verdana", Font.PLAIN, 12));
		textEmail.setColumns(10);
		boxHorizontalEmail.add(textEmail);

		Component horizontal_contato_4 = Box.createHorizontalStrut(20);
		horizontal_contato_4.setBounds(10, 419, 750, 32);
		add(horizontal_contato_4);

		Box tituloBoxVerticalOutrasInformacoes = Box.createVerticalBox();
		tituloBoxVerticalOutrasInformacoes.setBounds(10, 451, 750, 45);
		add(tituloBoxVerticalOutrasInformacoes);

		JLabel labelOutrasInformacoes = new JLabel("OUTRAS INFORMAÇÕES");
		labelOutrasInformacoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelOutrasInformacoes.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalOutrasInformacoes.add(labelOutrasInformacoes);

		JSeparator hr_outrasInformacoes = new JSeparator();
		tituloBoxVerticalOutrasInformacoes.add(hr_outrasInformacoes);

		Box boxHorizontalOutrasInformacoes = Box.createHorizontalBox();
		boxHorizontalOutrasInformacoes.setBounds(10, 504, 750, 32);
		add(boxHorizontalOutrasInformacoes);

		Box boxHorizontalGenero = Box.createHorizontalBox();
		boxHorizontalGenero.setAlignmentY(0.5f);
		boxHorizontalGenero.setBounds(10, 499, 750, 32);
		boxHorizontalOutrasInformacoes.add(boxHorizontalGenero);

		JLabel labelGenero = new JLabel("Gênero:");
		labelGenero.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalGenero.add(labelGenero);

		JLabel labelInfo_6 = new JLabel("*");
		labelInfo_6.setForeground(Color.RED);
		labelInfo_6.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalGenero.add(labelInfo_6);

		Component horizontal_outrasinformacoes_1 = Box.createHorizontalStrut(8);
		boxHorizontalGenero.add(horizontal_outrasinformacoes_1);

		comboBoxGenero.setModel(new DefaultComboBoxModel<Object>(EnumGenero.values()));
		comboBoxGenero.setSelectedIndex(0);
		boxHorizontalGenero.add(comboBoxGenero);

		Box boxHorizontalAcao = Box.createHorizontalBox();
		boxHorizontalAcao.setAlignmentY(0.5f);
		boxHorizontalAcao.setBounds(10, 570, 750, 32);
		add(boxHorizontalAcao);

		Component horizontal_acao_1 = Box.createHorizontalStrut(570);
		boxHorizontalAcao.add(horizontal_acao_1);

		Box boxHorizontalCancelarEProximo = Box.createHorizontalBox();
		boxHorizontalCancelarEProximo.setAlignmentY(Component.CENTER_ALIGNMENT);
		boxHorizontalAcao.add(boxHorizontalCancelarEProximo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta = JOptionPane.showConfirmDialog(null, "Esta ação irá apagar todos os dados cadastrados.",
						"Apagar Dados", JOptionPane.OK_CANCEL_OPTION);
				if (resposta == JOptionPane.OK_OPTION) {
					cadastroPanel.switchToCancelTab();
				}
			}
		});
		boxHorizontalCancelarEProximo.add(btnCancelar);

		Component horizontal_acao_2 = Box.createHorizontalStrut(8);
		boxHorizontalCancelarEProximo.add(horizontal_acao_2);

		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pacienteFullDTO.setDataNascimento(LocalDate.of(2000, 3, 25));
					pacienteFullDTO.setNome(textNome.getText());
					pacienteFullDTO.setCpf(textCpf.getText());
					pacienteFullDTO.setRg(textRg.getText());
					pacienteFullDTO.setCelular(Long.parseLong(textCelular.getText()));
					pacienteFullDTO.setTelefone(Long.parseLong(textTelefone.getText()));
					pacienteFullDTO.setEmail(textEmail.getText());
					pacienteFullDTO.setGenero((EnumGenero) comboBoxGenero.getSelectedItem());

					cadastroPanel.switchToNextTab();
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null,
							"Por favor, preencha todos os campos corretamente antes de prosseguir.");
				}
			}
		});
		boxHorizontalCancelarEProximo.add(btnProximo);

	}
}