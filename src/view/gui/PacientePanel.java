package view.gui;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.persistence.dao.paciente.PacienteFullDTO;

public class PacientePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private final ButtonGroup fumanteGroup = new ButtonGroup();
	private final ButtonGroup marcaPassoGroup = new ButtonGroup();

	private TextField textAltura = new TextField();
	private Box numeroCarBox = Box.createHorizontalBox();
	private Box marcaPassoBox = Box.createHorizontalBox();
	private TextField textNumeroCarteirinha = new TextField();
	private TextField textPrestadora = new TextField();
	private TextField textPlano = new TextField();
	private TextArea textAreaAlergias = new TextArea();
	private TextArea textMedicamentos = new TextArea();
	private TextArea textAreacondicaoMedica = new TextArea();

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
		textMedicamentos.setText("");
		textAreacondicaoMedica.setText("");
	}

	public PacientePanel(PacienteFullDTO pacienteFullDTO, CadastroPanel cadastroPanel) {
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

		Box fumanteBox = Box.createHorizontalBox();
		fumanteBox.setMinimumSize(new Dimension(200, 32));
		fumanteBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		pacienteBox.add(fumanteBox);

		textAltura.setName("prestadora");
		textAltura.setFont(new Font("Verdana", Font.PLAIN, 12));
		fumanteBox.add(textAltura);

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

		numeroCarBox.setMinimumSize(new Dimension(200, 32));
		numeroCarBox.setAlignmentY(0.5f);
		convenioBox.add(numeroCarBox);

		JLabel lblNumeroCar = new JLabel("Número da Carteirinha:");
		lblNumeroCar.setFont(new Font("Verdana", Font.BOLD, 16));
		numeroCarBox.add(lblNumeroCar);

		Component horizontalStrut_4 = Box.createHorizontalStrut(8);
		horizontalStrut_4.setMaximumSize(new Dimension(16, 32767));
		numeroCarBox.add(horizontalStrut_4);

		textNumeroCarteirinha.setName("prestadora");
		textNumeroCarteirinha.setFont(new Font("Verdana", Font.PLAIN, 12));
		numeroCarBox.add(textNumeroCarteirinha);

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

		textPrestadora.setFont(new Font("Verdana", Font.PLAIN, 12));
		textPrestadora.setName("prestadora");
		prestadoraBox.add(textPrestadora);

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

		textPlano.setName("plano");
		textPlano.setFont(new Font("Verdana", Font.PLAIN, 12));
		planoBox.add(textPlano);

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

		condicaoMedicaBox.add(textAreacondicaoMedica);

		Component verticalStrut_1_1 = Box.createVerticalStrut(20);
		historicoMedicoBox.add(verticalStrut_1_1);

		Box acaoBox = Box.createHorizontalBox();
		acaoBox.setAlignmentY(Component.CENTER_ALIGNMENT);
		acaoBox.setBounds(605, 570, 154, 32);
		add(acaoBox);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroPanel.switchToCancelTab();
			}
		});
		acaoBox.add(btnCancelar);

		Component horizontalStrut_5 = Box.createHorizontalStrut(8);
		acaoBox.add(horizontalStrut_5);

		JButton btnProximo = new JButton("Próximo");
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pacienteFullDTO.setAltura(148);
				pacienteFullDTO.setFumante(false);
				pacienteFullDTO.setMarcaPasso(true);
				pacienteFullDTO.setNumeroCarteirinha(121311312);
				pacienteFullDTO.setPrestadora("Bradesco");
				pacienteFullDTO.setPlano("lorem ipsum");
				pacienteFullDTO.setAlergias("lorem ipsum");
				pacienteFullDTO.setMedicamentos("lorem ipsum");
				pacienteFullDTO.setCondicaoMedica("lorem ipsum");

				cadastroPanel.switchToNextTab();
			}
		});
		acaoBox.add(btnProximo);

		Box voltarBox = Box.createHorizontalBox();
		voltarBox.setAlignmentY(0.5f);
		voltarBox.setBounds(10, 570, 58, 32);
		add(voltarBox);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroPanel.switchToBackTab();
			}
		});
		voltarBox.add(btnVoltar);
	}
}
