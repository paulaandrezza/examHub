package view.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import model.persistence.dao.paciente.PacienteFullDTO;
import view.utils.FieldMask;

public class PacientePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JFormattedTextField textAltura = new JFormattedTextField();
	private final ButtonGroup fumanteGroup = new ButtonGroup();
	private final ButtonGroup marcaPassoGroup = new ButtonGroup();
	private Box boxHorizontalNumeroCarterinha = Box.createHorizontalBox();
	private Box boxHorizontalmarcaPasso = Box.createHorizontalBox();
	private JTextField textNumeroCarteirinha = new JTextField();
	private JTextField textPrestadora = new JTextField();
	private JTextField textPlano = new JTextField();
	private JTextArea textAreaAlergias = new JTextArea();
	private JTextArea textAreaMedicamentos = new JTextArea();
	private JTextArea textAreaCondicaoMedica = new JTextArea();

	/**
	 * Create the panel.
	 */
	public void clearPacienteFields() {
		textAltura.setText("");
		textNumeroCarteirinha.setText("");
		fumanteGroup.clearSelection();
		marcaPassoGroup.clearSelection();
		textNumeroCarteirinha.setText("");
		textPrestadora.setText("");
		textPlano.setText("");
		textAreaAlergias.setText("");
		textAreaMedicamentos.setText("");
		textAreaCondicaoMedica.setText("");
	}

	public PacientePanel(PacienteFullDTO pacienteFullDTO, CadastroPanel cadastroPanel) {
		setBackground(UIManager.getColor("menu"));
		setLayout(null);

		Box tituloBoxHorizontalPaciente = Box.createVerticalBox();
		tituloBoxHorizontalPaciente.setBounds(10, 10, 750, 45);
		add(tituloBoxHorizontalPaciente);

		JLabel labelPaciente = new JLabel("PACIENTE");
		tituloBoxHorizontalPaciente.add(labelPaciente);
		labelPaciente.setHorizontalAlignment(SwingConstants.LEFT);
		labelPaciente.setFont(new Font("Verdana", Font.BOLD, 32));

		JSeparator hr_paciente_1 = new JSeparator();
		tituloBoxHorizontalPaciente.add(hr_paciente_1);

		Box boxHorizontalPaciente = Box.createHorizontalBox();
		boxHorizontalPaciente.setAlignmentY(Component.CENTER_ALIGNMENT);
		boxHorizontalPaciente.setBounds(10, 65, 750, 32);
		add(boxHorizontalPaciente);

		Box boxHorizontalAltura = Box.createHorizontalBox();
		boxHorizontalPaciente.add(boxHorizontalAltura);
		boxHorizontalAltura.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		boxHorizontalAltura.setMinimumSize(new Dimension(200, 32));
		boxHorizontalAltura.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel labelAltura = new JLabel("Altura:");
		boxHorizontalAltura.add(labelAltura);
		labelAltura.setAlignmentX(Component.CENTER_ALIGNMENT);
		labelAltura.setFont(new Font("Verdana", Font.BOLD, 16));

		JLabel labelInfo_1 = new JLabel("*");
		labelInfo_1.setForeground(Color.RED);
		labelInfo_1.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalAltura.add(labelInfo_1);

		Component horizontal_paciente_1 = Box.createHorizontalStrut(8);
		horizontal_paciente_1.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalAltura.add(horizontal_paciente_1);

		try {
			MaskFormatter mascarAltura = new MaskFormatter("###cm");
			textAltura = new JFormattedTextField(mascarAltura);
			textAltura.setFont(new Font("Verdana", Font.PLAIN, 12));
			boxHorizontalAltura.add(textAltura);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Component horizontal_paciente_2 = Box.createHorizontalStrut(32);
		horizontal_paciente_2.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalPaciente.add(horizontal_paciente_2);

		Box boxHorizontalFumante = Box.createHorizontalBox();
		boxHorizontalFumante.setMinimumSize(new Dimension(200, 32));
		boxHorizontalFumante.setAlignmentY(Component.CENTER_ALIGNMENT);
		boxHorizontalPaciente.add(boxHorizontalFumante);

		JLabel labelFumante = new JLabel("Fumante:");
		labelFumante.setFont(new Font("Verdana", Font.BOLD, 16));
		labelFumante.setAlignmentX(0.5f);
		boxHorizontalFumante.add(labelFumante);

		JLabel labelInfo_2 = new JLabel("*");
		labelInfo_2.setForeground(Color.RED);
		labelInfo_2.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalFumante.add(labelInfo_2);

		Component horizontal_paciente_3 = Box.createHorizontalStrut(8);
		horizontal_paciente_3.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalFumante.add(horizontal_paciente_3);

		Box radioBoxFumante = Box.createHorizontalBox();
		radioBoxFumante.setAlignmentY(Component.CENTER_ALIGNMENT);
		boxHorizontalFumante.add(radioBoxFumante);

		JRadioButton btnYesFumante = new JRadioButton("Sim");
		fumanteGroup.add(btnYesFumante);
		radioBoxFumante.add(btnYesFumante);
		btnYesFumante.setFont(new Font("Verdana", Font.PLAIN, 12));

		Component horizontal_paciente_4 = Box.createHorizontalStrut(8);
		radioBoxFumante.add(horizontal_paciente_4);

		JRadioButton btnNoFumante = new JRadioButton("Não");
		fumanteGroup.add(btnNoFumante);
		radioBoxFumante.add(btnNoFumante);
		btnNoFumante.setFont(new Font("Verdana", Font.PLAIN, 12));

		Component horizontal_paciente_5 = Box.createHorizontalStrut(32);
		horizontal_paciente_5.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalPaciente.add(horizontal_paciente_5);

		boxHorizontalmarcaPasso.setMinimumSize(new Dimension(200, 32));
		boxHorizontalmarcaPasso.setAlignmentY(0.5f);
		boxHorizontalPaciente.add(boxHorizontalmarcaPasso);

		JLabel labelMarcaPasso = new JLabel("Marca Passo:");
		labelMarcaPasso.setFont(new Font("Verdana", Font.BOLD, 16));
		labelMarcaPasso.setAlignmentX(0.5f);
		boxHorizontalmarcaPasso.add(labelMarcaPasso);

		JLabel labelInfo_3 = new JLabel("*");
		labelInfo_3.setForeground(Color.RED);
		labelInfo_3.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalmarcaPasso.add(labelInfo_3);

		Component horizontal_paciente_6 = Box.createHorizontalStrut(8);
		horizontal_paciente_6.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalmarcaPasso.add(horizontal_paciente_6);

		Box radioBoxMarcaPasso = Box.createHorizontalBox();
		boxHorizontalmarcaPasso.add(radioBoxMarcaPasso);

		JRadioButton btnYesMarcaPasso = new JRadioButton("Sim");
		marcaPassoGroup.add(btnYesMarcaPasso);
		btnYesMarcaPasso.setFont(new Font("Verdana", Font.PLAIN, 12));
		radioBoxMarcaPasso.add(btnYesMarcaPasso);

		Component horizontal_paciente_7 = Box.createHorizontalStrut(8);
		radioBoxMarcaPasso.add(horizontal_paciente_7);

		JRadioButton btnNoMarcaPasso = new JRadioButton("Não");
		marcaPassoGroup.add(btnNoMarcaPasso);
		btnNoMarcaPasso.setFont(new Font("Verdana", Font.PLAIN, 12));
		radioBoxMarcaPasso.add(btnNoMarcaPasso);

		Component horizontal_pacientepanel_1 = Box.createHorizontalStrut(20);
		horizontal_pacientepanel_1.setBounds(10, 98, 750, 64);
		add(horizontal_pacientepanel_1);

		Box tituloBoxHorizontalConvenio = Box.createVerticalBox();
		tituloBoxHorizontalConvenio.setBounds(10, 162, 750, 45);
		add(tituloBoxHorizontalConvenio);

		JLabel labelConvenio = new JLabel("CONVÊNIO");
		labelConvenio.setHorizontalAlignment(SwingConstants.LEFT);
		labelConvenio.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxHorizontalConvenio.add(labelConvenio);

		JSeparator hr_convenio_1 = new JSeparator();
		tituloBoxHorizontalConvenio.add(hr_convenio_1);

		Box boxVerticalConvenio = Box.createVerticalBox();
		boxVerticalConvenio.setAlignmentY(0.5f);
		boxVerticalConvenio.setBounds(10, 210, 750, 128);
		add(boxVerticalConvenio);

		boxHorizontalNumeroCarterinha.setMinimumSize(new Dimension(200, 32));
		boxHorizontalNumeroCarterinha.setAlignmentY(0.5f);
		boxVerticalConvenio.add(boxHorizontalNumeroCarterinha);

		JLabel labelNumeroCarteirinha = new JLabel("Número da Carteirinha:");
		labelNumeroCarteirinha.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalNumeroCarterinha.add(labelNumeroCarteirinha);

		JLabel labelInfo_4 = new JLabel("*");
		labelInfo_4.setForeground(Color.RED);
		labelInfo_4.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalNumeroCarterinha.add(labelInfo_4);

		Component horizontal_convenio_1 = Box.createHorizontalStrut(8);
		horizontal_convenio_1.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalNumeroCarterinha.add(horizontal_convenio_1);

		textNumeroCarteirinha.setFont(new Font("Verdana", Font.PLAIN, 12));
		FieldMask fieldMaskNumeroCarteirinha = new FieldMask();
		fieldMaskNumeroCarteirinha.setMaskType(FieldMask.MaskType.NUMBERS_ONLY);
		fieldMaskNumeroCarteirinha.setMaskType(FieldMask.MaskType.NUMBERS_ONLY);
		fieldMaskNumeroCarteirinha.setMaxValue(Integer.MAX_VALUE);
		textNumeroCarteirinha.setDocument(fieldMaskNumeroCarteirinha);
		boxHorizontalNumeroCarterinha.add(textNumeroCarteirinha);

		Component vertical_convenio_1 = Box.createVerticalStrut(16);
		vertical_convenio_1.setBounds(139, 320, 1, 20);
		boxVerticalConvenio.add(vertical_convenio_1);

		Box boxHorizontalprestadora = Box.createHorizontalBox();
		boxHorizontalprestadora.setMinimumSize(new Dimension(200, 32));
		boxHorizontalprestadora.setAlignmentY(0.5f);
		boxVerticalConvenio.add(boxHorizontalprestadora);

		JLabel labelPrestadora = new JLabel("Prestadora:");
		labelPrestadora.setFont(new Font("Verdana", Font.BOLD, 16));
		labelPrestadora.setAlignmentX(0.5f);
		boxHorizontalprestadora.add(labelPrestadora);

		JLabel labelInfo_5 = new JLabel("*");
		labelInfo_5.setForeground(Color.RED);
		labelInfo_5.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalprestadora.add(labelInfo_5);

		Component horizontal_convenio_2 = Box.createHorizontalStrut(8);
		horizontal_convenio_2.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalprestadora.add(horizontal_convenio_2);

		textPrestadora.setFont(new Font("Verdana", Font.PLAIN, 12));
		textPrestadora.setName("prestadora");
		boxHorizontalprestadora.add(textPrestadora);

		Component vertical_convenio_2 = Box.createVerticalStrut(16);
		vertical_convenio_2.setBounds(0, 336, 750, 20);
		boxVerticalConvenio.add(vertical_convenio_2);

		Box boxHorizontalPlano = Box.createHorizontalBox();
		boxHorizontalPlano.setMinimumSize(new Dimension(200, 32));
		boxHorizontalPlano.setAlignmentY(0.5f);
		boxVerticalConvenio.add(boxHorizontalPlano);

		JLabel labelPlano = new JLabel("Plano:");
		labelPlano.setFont(new Font("Verdana", Font.BOLD, 16));
		labelPlano.setAlignmentX(0.5f);
		boxHorizontalPlano.add(labelPlano);

		Component horizontal_convenio_3 = Box.createHorizontalStrut(20);
		horizontal_convenio_3.setMaximumSize(new Dimension(16, 32767));
		boxHorizontalPlano.add(horizontal_convenio_3);

		textPlano.setName("plano");
		textPlano.setFont(new Font("Verdana", Font.PLAIN, 12));
		boxHorizontalPlano.add(textPlano);

		Component horizontal_pacientePanel_2 = Box.createHorizontalStrut(20);
		horizontal_pacientePanel_2.setBounds(10, 336, 750, 64);
		add(horizontal_pacientePanel_2);

		Box tituloBoxVerticalHistoricoMedico = Box.createVerticalBox();
		tituloBoxVerticalHistoricoMedico.setBounds(10, 393, 750, 45);
		add(tituloBoxVerticalHistoricoMedico);

		JLabel labelHistoricoMedicoTitulo = new JLabel("HISTÓRICO MÉDICO");
		labelHistoricoMedicoTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		labelHistoricoMedicoTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalHistoricoMedico.add(labelHistoricoMedicoTitulo);

		JSeparator hr_historicoMedico_1 = new JSeparator();
		tituloBoxVerticalHistoricoMedico.add(hr_historicoMedico_1);

		Box boxHorizontalhistoricoMedico = Box.createHorizontalBox();
		boxHorizontalhistoricoMedico.setAlignmentY(0.5f);
		boxHorizontalhistoricoMedico.setBounds(10, 448, 750, 96);
		add(boxHorizontalhistoricoMedico);

		Box boxVerticalAlergias = Box.createVerticalBox();
		boxVerticalAlergias.setMinimumSize(new Dimension(200, 32));
		boxVerticalAlergias.setAlignmentY(0.5f);
		boxHorizontalhistoricoMedico.add(boxVerticalAlergias);

		JLabel labelAlergias = new JLabel("Alergias:");
		labelAlergias.setFont(new Font("Verdana", Font.BOLD, 16));
		labelAlergias.setAlignmentX(0.5f);
		boxVerticalAlergias.add(labelAlergias);
		textAreaAlergias.setFont(new Font("Verdana", Font.PLAIN, 12));
		textAreaAlergias.setLineWrap(true);
		textAreaAlergias.setWrapStyleWord(true);

		JScrollPane scrollPaneAlergias = new JScrollPane(textAreaAlergias);
		boxVerticalAlergias.add(scrollPaneAlergias);

		Component horizontal_historicomedico_1 = Box.createHorizontalStrut(32);
		boxHorizontalhistoricoMedico.add(horizontal_historicomedico_1);

		Box boxVerticalMedicamentos = Box.createVerticalBox();
		boxVerticalMedicamentos.setMinimumSize(new Dimension(200, 32));
		boxVerticalMedicamentos.setAlignmentY(0.5f);
		boxHorizontalhistoricoMedico.add(boxVerticalMedicamentos);

		JLabel labelMedicamentos = new JLabel("Medicamentos:");
		labelMedicamentos.setFont(new Font("Verdana", Font.BOLD, 16));
		labelMedicamentos.setAlignmentX(0.5f);
		boxVerticalMedicamentos.add(labelMedicamentos);
		textAreaMedicamentos.setFont(new Font("Verdana", Font.PLAIN, 12));
		textAreaMedicamentos.setLineWrap(true);
		textAreaMedicamentos.setWrapStyleWord(true);

		JScrollPane scrollPaneMedicamentos = new JScrollPane(textAreaMedicamentos);
		boxVerticalMedicamentos.add(scrollPaneMedicamentos);

		Component horizontal_historicomedico_2 = Box.createHorizontalStrut(32);
		boxHorizontalhistoricoMedico.add(horizontal_historicomedico_2);

		Box boxVerticalCondicaoMedica = Box.createVerticalBox();
		boxVerticalCondicaoMedica.setMinimumSize(new Dimension(200, 32));
		boxVerticalCondicaoMedica.setAlignmentY(0.5f);
		boxHorizontalhistoricoMedico.add(boxVerticalCondicaoMedica);

		JLabel labelCondicaoMedica = new JLabel("Condição Médica:");
		labelCondicaoMedica.setFont(new Font("Verdana", Font.BOLD, 16));
		labelCondicaoMedica.setAlignmentX(0.5f);
		boxVerticalCondicaoMedica.add(labelCondicaoMedica);
		textAreaCondicaoMedica.setFont(new Font("Verdana", Font.PLAIN, 12));
		textAreaCondicaoMedica.setLineWrap(true);
		textAreaCondicaoMedica.setWrapStyleWord(true);

		JScrollPane scrollPaneCondicaoMedica = new JScrollPane(textAreaCondicaoMedica);
		boxVerticalCondicaoMedica.add(scrollPaneCondicaoMedica);

		Box boxHorizontalAcao = Box.createHorizontalBox();
		boxHorizontalAcao.setAlignmentY(Component.CENTER_ALIGNMENT);
		boxHorizontalAcao.setBounds(10, 570, 750, 32);
		add(boxHorizontalAcao);

		Box boxHorizontalVoltar = Box.createHorizontalBox();
		boxHorizontalVoltar.setAlignmentY(0.5f);
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

		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Float altura = Float.parseFloat(textAltura.getText().replaceAll("cm", "")) / 100;
					Float alturaFormatada = (float) (Math.round(altura * 100.0) / 100.0);
					pacienteFullDTO.setAltura(alturaFormatada);
					pacienteFullDTO.setFumante(fumanteGroup.isSelected(btnYesFumante.getModel()) ? true : false);
					pacienteFullDTO.setFumante(marcaPassoGroup.isSelected(btnYesMarcaPasso.getModel()) ? true : false);
					pacienteFullDTO.setNumeroCarteirinha(Integer.parseInt(textNumeroCarteirinha.getText()));
					pacienteFullDTO.setPrestadora(textPrestadora.getText());

					if (textPlano.getText().equals("")) {
						pacienteFullDTO.setPlano(null);
					} else {
						pacienteFullDTO.setPlano(textPlano.getText());
					}

					if (textAreaAlergias.getText().equals("")) {
						pacienteFullDTO.setAlergias(null);
					} else {
						pacienteFullDTO.setAlergias(textAreaAlergias.getText());
					}

					if (textAreaMedicamentos.getText().equals("")) {
						pacienteFullDTO.setMedicamentos(null);
					} else {
						pacienteFullDTO.setMedicamentos(textAreaMedicamentos.getText());
					}

					if (textAreaCondicaoMedica.getText() == "") {
						pacienteFullDTO.setCondicaoMedica(null);
					} else {
						pacienteFullDTO.setCondicaoMedica(textAreaCondicaoMedica.getText());
					}

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
