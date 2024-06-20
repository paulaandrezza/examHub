package view.guiPaciente;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.ZoneId;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import model.enums.EnumGenero;
import model.persistence.dao.paciente.PacienteFullDTO;
import view.utils.FieldMask;

public class PessoaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private FieldMask fieldMask = new FieldMask();

	private JTextField textNome;
	private JFormattedTextField textCpf;
	private JFormattedTextField textRg;
	private JDateChooser textDataNascimento;
	private JFormattedTextField textCelular;
	private JFormattedTextField textTelefone;
	private JTextField textEmail;
	private JComboBox<Object> comboBoxGenero = new JComboBox<Object>();

	/**
	 * Create the panel.
	 */
	public void clearPessoaFields() {
		textNome.setText("");
		textCpf.setText("");
		textRg.setText("");
		textDataNascimento.setDate(null);
		textCelular.setText("");
		textTelefone.setText("");
		textEmail.setText("");
		comboBoxGenero.setSelectedIndex(0);
	}

	public PessoaPanel(PacienteFullDTO pacienteFullDTO, CadastroPanel cadastroPanel) {
		setBackground(UIManager.getColor("menu"));
		setLayout(null);

		Box tituloBoxVerticalDadosPessoais = Box.createVerticalBox();
		tituloBoxVerticalDadosPessoais.setBounds(125, 10, 750, 45);
		add(tituloBoxVerticalDadosPessoais);

		JLabel tituloDadosPessoais = new JLabel("DADOS PESSOAIS");
		tituloBoxVerticalDadosPessoais.add(tituloDadosPessoais);
		tituloDadosPessoais.setHorizontalAlignment(SwingConstants.LEFT);
		tituloDadosPessoais.setFont(new Font("Verdana", Font.BOLD, 32));

		JSeparator hr_dadosPessoais = new JSeparator();
		tituloBoxVerticalDadosPessoais.add(hr_dadosPessoais);

		Box boxHorizontalDadosPessoais = Box.createHorizontalBox();
		boxHorizontalDadosPessoais.setBounds(125, 65, 750, 32);
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
		textNome.setColumns(15);
		textNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		fieldMask.setMaskType(FieldMask.MaskType.LETTERS_ONLY);
		textNome.setDocument(fieldMask);
		boxHorizontalNome.add(textNome);

		Component horizontal_pessoapanel_1 = Box.createHorizontalStrut(20);
		horizontal_pessoapanel_1.setBounds(10, 97, 750, 32);
		add(horizontal_pessoapanel_1);

		Box tituloBoxVerticalDocumentos = Box.createVerticalBox();
		tituloBoxVerticalDocumentos.setBounds(125, 129, 750, 45);
		add(tituloBoxVerticalDocumentos);

		JLabel documentosLabel = new JLabel("DOCUMENTOS");
		documentosLabel.setHorizontalAlignment(SwingConstants.LEFT);
		documentosLabel.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalDocumentos.add(documentosLabel);

		JSeparator hr_documentos = new JSeparator();
		tituloBoxVerticalDocumentos.add(hr_documentos);

		Box boxHorizontalDocumentos = Box.createHorizontalBox();
		boxHorizontalDocumentos.setBounds(125, 177, 750, 32);
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

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			textCpf = new JFormattedTextField(mascaraCpf);
			textCpf.setFont(new Font("Verdana", Font.PLAIN, 12));
			boxHorizontalCpf.add(textCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}

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

		textRg = new JFormattedTextField();

		try {
			MaskFormatter mascaraRg = new MaskFormatter("##.###.###-*");
			textRg = new JFormattedTextField(mascaraRg);
			textRg.setFont(new Font("Verdana", Font.PLAIN, 12));
			boxHorizontalRg.add(textRg);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Component horizontal_dadosPessoais_2 = Box.createHorizontalStrut(32);
		boxHorizontalDadosPessoais.add(horizontal_dadosPessoais_2);

		Box boxHorizontalDataNascimento = Box.createHorizontalBox();
		boxHorizontalDataNascimento.setAlignmentX(Component.LEFT_ALIGNMENT);
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

		textDataNascimento = new JDateChooser();
		textDataNascimento.setFont(new Font("Verdana", Font.PLAIN, 12));
		textDataNascimento.setToolTipText("");
		textDataNascimento.setDateFormatString("dd/MM/yyyy");

		JTextFieldDateEditor editor = (JTextFieldDateEditor) textDataNascimento.getDateEditor();
		editor.setForeground(Color.BLACK);
		editor.setFont(new Font("Verdana", Font.PLAIN, 12));
		editor.setDateFormatString("dd/MM/yyyy");
		editor.setFocusLostBehavior(JFormattedTextField.PERSIST);

		boxHorizontalDataNascimento.add(textDataNascimento);

		Component horizontal_pessoapanel_2 = Box.createHorizontalStrut(20);
		horizontal_pessoapanel_2.setBounds(10, 209, 750, 32);
		add(horizontal_pessoapanel_2);

		Box tituloBoxVerticalContato = Box.createVerticalBox();
		tituloBoxVerticalContato.setBounds(125, 241, 750, 45);
		add(tituloBoxVerticalContato);

		JLabel labelContato = new JLabel("CONTATO");
		labelContato.setHorizontalAlignment(SwingConstants.LEFT);
		labelContato.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalContato.add(labelContato);

		JSeparator hr_contato = new JSeparator();
		tituloBoxVerticalContato.add(hr_contato);

		Box boxVerticalContato = Box.createVerticalBox();
		boxVerticalContato.setBounds(125, 289, 750, 128);
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

		try {
			MaskFormatter mascaraCelular = new MaskFormatter("(+55) ## ####-#####");
			textCelular = new JFormattedTextField(mascaraCelular);
			textCelular.setFont(new Font("Verdana", Font.PLAIN, 12));
			boxHorizontalCelular.add(textCelular);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Component vertical_contato_1 = Box.createVerticalStrut(16);
		boxVerticalContato.add(vertical_contato_1);

		Box boxHorizontalTelefone = Box.createHorizontalBox();
		boxHorizontalTelefone.setAlignmentY(0.5f);
		boxVerticalContato.add(boxHorizontalTelefone);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalTelefone.add(labelTelefone);

		JLabel labelInfo_8 = new JLabel("*");
		labelInfo_8.setForeground(Color.RED);
		labelInfo_8.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalTelefone.add(labelInfo_8);

		Component horizontal_contato_2 = Box.createHorizontalStrut(8);
		boxHorizontalTelefone.add(horizontal_contato_2);

		try {
			MaskFormatter mascaraTelefone = new MaskFormatter("(+55) ####-####");
			textTelefone = new JFormattedTextField(mascaraTelefone);
			textTelefone.setFont(new Font("Verdana", Font.PLAIN, 12));
			boxHorizontalTelefone.add(textTelefone);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Component vertical_contato_2 = Box.createVerticalStrut(16);
		boxVerticalContato.add(vertical_contato_2);

		Box boxHorizontalEmail = Box.createHorizontalBox();
		boxVerticalContato.add(boxHorizontalEmail);

		JLabel labelEmail = new JLabel("E-mail:");
		labelEmail.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalEmail.add(labelEmail);

		JLabel labelInfo_6 = new JLabel("*");
		labelInfo_6.setForeground(Color.RED);
		labelInfo_6.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalEmail.add(labelInfo_6);

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
		tituloBoxVerticalOutrasInformacoes.setBounds(125, 451, 750, 45);
		add(tituloBoxVerticalOutrasInformacoes);

		JLabel labelOutrasInformacoes = new JLabel("OUTRAS INFORMAÇÕES");
		labelOutrasInformacoes.setHorizontalAlignment(SwingConstants.LEFT);
		labelOutrasInformacoes.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalOutrasInformacoes.add(labelOutrasInformacoes);

		JSeparator hr_outrasInformacoes = new JSeparator();
		tituloBoxVerticalOutrasInformacoes.add(hr_outrasInformacoes);

		Box boxHorizontalOutrasInformacoes = Box.createHorizontalBox();
		boxHorizontalOutrasInformacoes.setBounds(125, 504, 750, 32);
		add(boxHorizontalOutrasInformacoes);

		Box boxHorizontalGenero = Box.createHorizontalBox();
		boxHorizontalGenero.setAlignmentY(0.5f);
		boxHorizontalGenero.setBounds(10, 499, 750, 32);
		boxHorizontalOutrasInformacoes.add(boxHorizontalGenero);

		JLabel labelGenero = new JLabel("Gênero:");
		labelGenero.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalGenero.add(labelGenero);

		JLabel labelInfo_7 = new JLabel("*");
		labelInfo_7.setForeground(Color.RED);
		labelInfo_7.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalGenero.add(labelInfo_7);

		Component horizontal_outrasinformacoes_1 = Box.createHorizontalStrut(8);
		boxHorizontalGenero.add(horizontal_outrasinformacoes_1);

		comboBoxGenero.setModel(new DefaultComboBoxModel<Object>(EnumGenero.values()));
		comboBoxGenero.setSelectedIndex(0);
		boxHorizontalGenero.add(comboBoxGenero);

		Box boxHorizontalAcao = Box.createHorizontalBox();
		boxHorizontalAcao.setAlignmentY(0.5f);
		boxHorizontalAcao.setBounds(125, 570, 750, 32);
		add(boxHorizontalAcao);

		Component horizontal_acao_1 = Box.createHorizontalStrut(570);
		boxHorizontalAcao.add(horizontal_acao_1);

		Box boxHorizontalCancelarEProximo = Box.createHorizontalBox();
		boxHorizontalCancelarEProximo.setAlignmentY(Component.CENTER_ALIGNMENT);
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

		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pacienteFullDTO.setDataNascimento(
							textDataNascimento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
					pacienteFullDTO.setNome(textNome.getText());
					pacienteFullDTO.setCpf(textCpf.getText());
					pacienteFullDTO.setRg(textRg.getText().toUpperCase());
					String celular = textCelular.getText().replaceAll("[^0-9]", "");
					pacienteFullDTO.setCelular(celular.isEmpty() ? 0 : Long.parseLong(celular));
					String telefone = textTelefone.getText().replaceAll("[^0-9]", "");
					if (telefone.equals("55")) {
						pacienteFullDTO.setTelefone(Long.parseLong(null));
					} else {
						pacienteFullDTO.setTelefone(telefone.isEmpty() ? 0 : Long.parseLong(telefone));
					}
					pacienteFullDTO.setEmail(textEmail.getText());
					pacienteFullDTO.setGenero((EnumGenero) comboBoxGenero.getSelectedItem());

					cadastroPanel.switchToNextTab();
				} catch (Exception a) {
					System.out.println(a);
					JOptionPane.showMessageDialog(null, cadastroPanel.errorMessage());
				}
			}
		});

		boxHorizontalCancelarEProximo.add(btnProximo);

	}
}