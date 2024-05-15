package view.gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PacientePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final ButtonGroup fumanteGroup = new ButtonGroup();
	private final ButtonGroup marcaPassoGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public PacientePanel() {
		setBackground(UIManager.getColor("menu"));
		setLayout(null);

		Box pacienteBox = Box.createHorizontalBox();
		pacienteBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		pacienteBox.setBounds(10, 65, 750, 32);
		add(pacienteBox);

		Box alturaBox = Box.createHorizontalBox();
		pacienteBox.add(alturaBox);
		alturaBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		alturaBox.setMinimumSize(new Dimension(200, 32));
		alturaBox.setAlignmentY(Component.CENTER_ALIGNMENT);

		JLabel lblAltura = new JLabel("Altura:");
		alturaBox.add(lblAltura);
		lblAltura.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAltura.setFont(new Font("Verdana", Font.BOLD, 16));

		Component horizontalStrut = Box.createHorizontalStrut(8);
		horizontalStrut.setMaximumSize(new Dimension(16, 32767));
		alturaBox.add(horizontalStrut);

		JSpinner spinnerAltura = new JSpinner();
		alturaBox.add(spinnerAltura);
		spinnerAltura.setFont(new Font("Verdana", Font.PLAIN, 12));
		spinnerAltura.setModel(
				new SpinnerNumberModel(Float.valueOf(0), Float.valueOf(0), Float.valueOf(3), Float.valueOf(1)));

		Box fumanteBox = Box.createHorizontalBox();
		fumanteBox.setMinimumSize(new Dimension(200, 32));
		fumanteBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		pacienteBox.add(fumanteBox);

		Component horizontalStrut_1_1 = Box.createHorizontalStrut(32);
		horizontalStrut_1_1.setMaximumSize(new Dimension(16, 32767));
		fumanteBox.add(horizontalStrut_1_1);

		JLabel lblFumante = new JLabel("Fumante:");
		lblFumante.setFont(new Font("Verdana", Font.BOLD, 16));
		lblFumante.setAlignmentX(0.5f);
		fumanteBox.add(lblFumante);

		Component horizontalStrut_1 = Box.createHorizontalStrut(8);
		horizontalStrut_1.setMaximumSize(new Dimension(16, 32767));
		fumanteBox.add(horizontalStrut_1);

		Box radioFumanteBox = Box.createHorizontalBox();
		radioFumanteBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		fumanteBox.add(radioFumanteBox);

		JRadioButton rdbtnFumanteYes = new JRadioButton("Sim");
		fumanteGroup.add(rdbtnFumanteYes);
		radioFumanteBox.add(rdbtnFumanteYes);
		rdbtnFumanteYes.setFont(new Font("Verdana", Font.PLAIN, 12));

		Component horizontalStrut_2 = Box.createHorizontalStrut(8);
		radioFumanteBox.add(horizontalStrut_2);

		JRadioButton rdbtnFumanteNo = new JRadioButton("Não");
		fumanteGroup.add(rdbtnFumanteNo);
		radioFumanteBox.add(rdbtnFumanteNo);
		rdbtnFumanteNo.setFont(new Font("Verdana", Font.PLAIN, 12));

		Box marcaPassoBox = Box.createHorizontalBox();
		marcaPassoBox.setMinimumSize(new Dimension(200, 32));
		marcaPassoBox.setAlignmentY(0.5f);
		pacienteBox.add(marcaPassoBox);

		Component horizontalStrut_1_1_1 = Box.createHorizontalStrut(32);
		horizontalStrut_1_1_1.setMaximumSize(new Dimension(16, 32767));
		marcaPassoBox.add(horizontalStrut_1_1_1);

		JLabel lblMarcaPasso = new JLabel("Marca Passo:");
		lblMarcaPasso.setFont(new Font("Verdana", Font.BOLD, 16));
		lblMarcaPasso.setAlignmentX(0.5f);
		marcaPassoBox.add(lblMarcaPasso);

		Component horizontalStrut_1_2 = Box.createHorizontalStrut(8);
		horizontalStrut_1_2.setMaximumSize(new Dimension(16, 32767));
		marcaPassoBox.add(horizontalStrut_1_2);

		Box radioMarcaPassoBox = Box.createHorizontalBox();
		marcaPassoBox.add(radioMarcaPassoBox);

		JRadioButton rdbtnMarcaPassoYes = new JRadioButton("Sim");
		marcaPassoGroup.add(rdbtnMarcaPassoYes);
		rdbtnMarcaPassoYes.setFont(new Font("Verdana", Font.PLAIN, 12));
		radioMarcaPassoBox.add(rdbtnMarcaPassoYes);

		Component horizontalStrut_2_1 = Box.createHorizontalStrut(8);
		radioMarcaPassoBox.add(horizontalStrut_2_1);

		JRadioButton rdbtnMarcaPassoNo = new JRadioButton("Não");
		marcaPassoGroup.add(rdbtnMarcaPassoNo);
		rdbtnMarcaPassoNo.setFont(new Font("Verdana", Font.PLAIN, 12));
		radioMarcaPassoBox.add(rdbtnMarcaPassoNo);

		Box pacienteTitulo = Box.createVerticalBox();
		pacienteTitulo.setBounds(10, 10, 750, 45);
		add(pacienteTitulo);

		JLabel lblPacienteTitulo = new JLabel("PACIENTE");
		pacienteTitulo.add(lblPacienteTitulo);
		lblPacienteTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPacienteTitulo.setFont(new Font("Verdana", Font.BOLD, 32));

		JSeparator hr = new JSeparator();
		pacienteTitulo.add(hr);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalStrut_3.setBounds(10, 98, 750, 64);
		add(horizontalStrut_3);

		Box convenioTitulo = Box.createVerticalBox();
		convenioTitulo.setBounds(10, 162, 750, 45);
		add(convenioTitulo);

		JLabel lblConvenioTitulo = new JLabel("CONVÊNIO");
		lblConvenioTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblConvenioTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		convenioTitulo.add(lblConvenioTitulo);

		JSeparator hr_1 = new JSeparator();
		convenioTitulo.add(hr_1);

		Box convenioBox = Box.createVerticalBox();
		convenioBox.setAlignmentY(0.5f);
		convenioBox.setBounds(10, 210, 750, 128);
		add(convenioBox);

		Box numeroCarBox = Box.createHorizontalBox();
		numeroCarBox.setMinimumSize(new Dimension(200, 32));
		numeroCarBox.setAlignmentY(0.5f);
		convenioBox.add(numeroCarBox);

		JLabel lblNumeroCar = new JLabel("Número da Carteirinha:");
		lblNumeroCar.setFont(new Font("Verdana", Font.BOLD, 16));
		numeroCarBox.add(lblNumeroCar);

		Component horizontalStrut_4 = Box.createHorizontalStrut(8);
		horizontalStrut_4.setMaximumSize(new Dimension(16, 32767));
		numeroCarBox.add(horizontalStrut_4);

		JSpinner spinnerNumeroCar = new JSpinner();
		spinnerNumeroCar
				.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinnerNumeroCar.setFont(new Font("Verdana", Font.PLAIN, 12));
		numeroCarBox.add(spinnerNumeroCar);

		Component verticalStrut = Box.createVerticalStrut(16);
		verticalStrut.setBounds(139, 320, 1, 20);
		convenioBox.add(verticalStrut);

		Box prestadoraBox = Box.createHorizontalBox();
		prestadoraBox.setMinimumSize(new Dimension(200, 32));
		prestadoraBox.setAlignmentY(0.5f);
		convenioBox.add(prestadoraBox);

		JLabel lblPrestadora = new JLabel("Prestadora:");
		lblPrestadora.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPrestadora.setAlignmentX(0.5f);
		prestadoraBox.add(lblPrestadora);

		Component horizontalStrut_1_3 = Box.createHorizontalStrut(8);
		horizontalStrut_1_3.setMaximumSize(new Dimension(16, 32767));
		prestadoraBox.add(horizontalStrut_1_3);

		TextField prestadoraField = new TextField();
		prestadoraField.setFont(new Font("Verdana", Font.PLAIN, 12));
		prestadoraField.setName("prestadora");
		prestadoraBox.add(prestadoraField);

		Component verticalStrut_1 = Box.createVerticalStrut(16);
		verticalStrut_1.setBounds(0, 336, 750, 20);
		convenioBox.add(verticalStrut_1);

		Box planoBox = Box.createHorizontalBox();
		planoBox.setMinimumSize(new Dimension(200, 32));
		planoBox.setAlignmentY(0.5f);
		convenioBox.add(planoBox);

		JLabel lblPlano = new JLabel("Plano:");
		lblPlano.setFont(new Font("Verdana", Font.BOLD, 16));
		lblPlano.setAlignmentX(0.5f);
		planoBox.add(lblPlano);

		Component horizontalStrut_1_2_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1_2_1.setMaximumSize(new Dimension(16, 32767));
		planoBox.add(horizontalStrut_1_2_1);

		TextField planoField = new TextField();
		planoField.setName("plano");
		planoField.setFont(new Font("Verdana", Font.PLAIN, 12));
		planoBox.add(planoField);

		Component horizontalStrut_3_1 = Box.createHorizontalStrut(20);
		horizontalStrut_3_1.setBounds(10, 336, 750, 64);
		add(horizontalStrut_3_1);

		Box historicoMedicoTitulo = Box.createVerticalBox();
		historicoMedicoTitulo.setBounds(10, 393, 750, 45);
		add(historicoMedicoTitulo);

		JLabel lblHistoricoMedicoTitulo = new JLabel("HISTÓRICO MÉDICO");
		lblHistoricoMedicoTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblHistoricoMedicoTitulo.setFont(new Font("Verdana", Font.BOLD, 32));
		historicoMedicoTitulo.add(lblHistoricoMedicoTitulo);

		JSeparator hr_1_1 = new JSeparator();
		historicoMedicoTitulo.add(hr_1_1);

		Box historicoMedicoBox = Box.createHorizontalBox();
		historicoMedicoBox.setAlignmentY(0.5f);
		historicoMedicoBox.setBounds(10, 448, 750, 96);
		add(historicoMedicoBox);

		Box alergiasBox = Box.createVerticalBox();
		alergiasBox.setMinimumSize(new Dimension(200, 32));
		alergiasBox.setAlignmentY(0.5f);
		historicoMedicoBox.add(alergiasBox);

		JLabel lblAlergias = new JLabel("Alergias:");
		lblAlergias.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAlergias.setAlignmentX(0.5f);
		alergiasBox.add(lblAlergias);

		TextArea textAreaAlergias = new TextArea();
		alergiasBox.add(textAreaAlergias);

		Component verticalStrut_2 = Box.createHorizontalStrut(32);
		historicoMedicoBox.add(verticalStrut_2);

		Box medicamentosBox = Box.createVerticalBox();
		medicamentosBox.setMinimumSize(new Dimension(200, 32));
		medicamentosBox.setAlignmentY(0.5f);
		historicoMedicoBox.add(medicamentosBox);

		JLabel lblMedicamentos = new JLabel("Medicamentos:");
		lblMedicamentos.setFont(new Font("Verdana", Font.BOLD, 16));
		lblMedicamentos.setAlignmentX(0.5f);
		medicamentosBox.add(lblMedicamentos);

		TextArea textMedicamentos = new TextArea();
		medicamentosBox.add(textMedicamentos);

		Component verticalStrut_1_2 = Box.createHorizontalStrut(32);
		historicoMedicoBox.add(verticalStrut_1_2);

		Box condicaoMedicaBox = Box.createVerticalBox();
		condicaoMedicaBox.setMinimumSize(new Dimension(200, 32));
		condicaoMedicaBox.setAlignmentY(0.5f);
		historicoMedicoBox.add(condicaoMedicaBox);

		JLabel lblcondicaoMedica = new JLabel("Condição Médica:");
		lblcondicaoMedica.setFont(new Font("Verdana", Font.BOLD, 16));
		lblcondicaoMedica.setAlignmentX(0.5f);
		condicaoMedicaBox.add(lblcondicaoMedica);

		TextArea textAreacondicaoMedica = new TextArea();
		condicaoMedicaBox.add(textAreacondicaoMedica);

		Component verticalStrut_1_1 = Box.createVerticalStrut(20);
		historicoMedicoBox.add(verticalStrut_1_1);

		Box acaoBox = Box.createHorizontalBox();
		acaoBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		acaoBox.setBounds(605, 570, 154, 32);
		add(acaoBox);

		JButton btnCancelar = new JButton("Cancelar");
		acaoBox.add(btnCancelar);

		Component horizontalStrut_5 = Box.createHorizontalStrut(8);
		acaoBox.add(horizontalStrut_5);

		JButton btnProximo_1 = new JButton("Próximo");
		acaoBox.add(btnProximo_1);

		Box voltarBox = Box.createHorizontalBox();
		voltarBox.setAlignmentY(0.5f);
		voltarBox.setBounds(10, 570, 58, 32);
		add(voltarBox);

		JButton btnVoltar_1 = new JButton("Voltar");
		voltarBox.add(btnVoltar_1);
	}
}
