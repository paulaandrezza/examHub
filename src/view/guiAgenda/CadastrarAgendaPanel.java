package view.guiAgenda;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import controller.AgendamentoController;
import controller.PacienteController;
import model.entities.Paciente;
import model.enums.EnumExame;
import model.persistence.dao.agendamento.AgendamentoDTO;
import view.utils.FieldMask;

public class CadastrarAgendaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JDateChooser textDataExame = new JDateChooser();
	private JTextField textNome;
	private JFormattedTextField textCpf = new JFormattedTextField((Object) null);
	private JTextField textMedicoSolicitante;
	private JComboBox<String> comboBoxHorarioExame = new JComboBox<>();
	private JComboBox<Object> comboBoxTipoExame = new JComboBox<Object>();

	public void clearAgendaFields() {
		textDataExame.setDate(null);
		textNome.setText("");
		textCpf.setText("");
		textMedicoSolicitante.setText("");
	}

	public CadastrarAgendaPanel(AgendamentoDTO agendamentoDTO, AgendamentoController agendamentoController,
			AgendaPanel agendaPanel) {
		setBounds(100, 100, 782, 603);
		setLayout(null);

		setBackground(SystemColor.menu);

		Box tituloBoxVerticalCadastrarAgenda = Box.createVerticalBox();
		tituloBoxVerticalCadastrarAgenda.setBounds(10, 10, 750, 42);
		add(tituloBoxVerticalCadastrarAgenda);

		JLabel tituloCadastrarAgenda = new JLabel("CADASTRAR AGENDA");
		tituloCadastrarAgenda.setHorizontalAlignment(SwingConstants.LEFT);
		tituloCadastrarAgenda.setFont(new Font("Verdana", Font.BOLD, 32));
		tituloBoxVerticalCadastrarAgenda.add(tituloCadastrarAgenda);

		JSeparator hr_cadastraragenda = new JSeparator();
		tituloBoxVerticalCadastrarAgenda.add(hr_cadastraragenda);

		Box boxVerticalCadastrarAgenda = Box.createVerticalBox();
		boxVerticalCadastrarAgenda.setBounds(10, 64, 740, 335);
		add(boxVerticalCadastrarAgenda);

		Box boxHorizontalDataExame = Box.createHorizontalBox();
		boxVerticalCadastrarAgenda.add(boxHorizontalDataExame);

		JLabel labelDataExame = new JLabel("Data do Exame:");
		labelDataExame.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalDataExame.add(labelDataExame);

		JLabel labelInfo_1 = new JLabel("*");
		labelInfo_1.setForeground(Color.RED);
		labelInfo_1.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalDataExame.add(labelInfo_1);

		Component horizontal_cadastraragenda_1 = Box.createHorizontalStrut(8);
		boxHorizontalDataExame.add(horizontal_cadastraragenda_1);

		textDataExame.setToolTipText("");
		textDataExame.setFont(new Font("Verdana", Font.PLAIN, 12));
		textDataExame.setDateFormatString("dd/MM/yyyy");
		boxHorizontalDataExame.add(textDataExame);

		Component horizontal_cadastraragenda_2 = Box.createHorizontalStrut(350);
		boxHorizontalDataExame.add(horizontal_cadastraragenda_2);

		Component vertical_cadastraragenda_1 = Box.createVerticalStrut(32);
		boxVerticalCadastrarAgenda.add(vertical_cadastraragenda_1);

		Box boxHorizontalNome = Box.createHorizontalBox();
		boxVerticalCadastrarAgenda.add(boxHorizontalNome);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalNome.add(labelNome);

		JLabel labelInfo_2 = new JLabel("*");
		labelInfo_2.setForeground(Color.RED);
		labelInfo_2.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalNome.add(labelInfo_2);

		Component horizontal_cadastraragenda_3 = Box.createHorizontalStrut(8);
		boxHorizontalNome.add(horizontal_cadastraragenda_3);

		textNome = new JTextField();
		textNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		textNome.setColumns(15);

		FieldMask fieldMaskNome = new FieldMask();
		fieldMaskNome.setMaskType(FieldMask.MaskType.LETTERS_ONLY);
		textNome.setDocument(fieldMaskNome);
		boxHorizontalNome.add(textNome);

		Component vertical_cadastraragenda_2 = Box.createVerticalStrut(32);
		boxVerticalCadastrarAgenda.add(vertical_cadastraragenda_2);

		Box boxHorizontalCpf = Box.createHorizontalBox();
		boxHorizontalCpf.setAlignmentY(0.5f);
		boxVerticalCadastrarAgenda.add(boxHorizontalCpf);

		JLabel labelCpf = new JLabel("CPF:");
		labelCpf.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCpf.add(labelCpf);

		JLabel labelInfo_3 = new JLabel("*");
		labelInfo_3.setForeground(Color.RED);
		labelInfo_3.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalCpf.add(labelInfo_3);

		Component horizontal_cadastraragenda_4 = Box.createHorizontalStrut(8);
		boxHorizontalCpf.add(horizontal_cadastraragenda_4);

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			textCpf = new JFormattedTextField(mascaraCpf);
			textCpf.setFont(new Font("Verdana", Font.PLAIN, 12));
			boxHorizontalCpf.add(textCpf);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Component vertical_cadastraragenda_4 = Box.createVerticalStrut(32);
		boxVerticalCadastrarAgenda.add(vertical_cadastraragenda_4);

		Box boxHorizontalMedicoSolicitante = Box.createHorizontalBox();
		boxVerticalCadastrarAgenda.add(boxHorizontalMedicoSolicitante);

		JLabel labelMedicoSolicitante = new JLabel("Médico Solicitante:");
		labelMedicoSolicitante.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalMedicoSolicitante.add(labelMedicoSolicitante);

		JLabel labelInfo_5 = new JLabel("*");
		labelInfo_5.setForeground(Color.RED);
		labelInfo_5.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalMedicoSolicitante.add(labelInfo_5);

		Component horizontal_cadastraragenda_5 = Box.createHorizontalStrut(8);
		boxHorizontalMedicoSolicitante.add(horizontal_cadastraragenda_5);

		textMedicoSolicitante = new JTextField();
		textMedicoSolicitante.setFont(new Font("Verdana", Font.PLAIN, 12));
		textMedicoSolicitante.setColumns(15);

		FieldMask fieldMaskMedicoSolicitante = new FieldMask();
		fieldMaskMedicoSolicitante.setMaskType(FieldMask.MaskType.LETTERS_ONLY);
		textMedicoSolicitante.setDocument(fieldMaskMedicoSolicitante);
		boxHorizontalMedicoSolicitante.add(textMedicoSolicitante);

		Component vertical_cadastraragenda_5 = Box.createVerticalStrut(32);
		boxVerticalCadastrarAgenda.add(vertical_cadastraragenda_5);

		JTextFieldDateEditor editor = (JTextFieldDateEditor) textDataExame.getDateEditor();
		editor.setForeground(Color.BLACK);
		editor.setFont(new Font("Verdana", Font.PLAIN, 12));
		editor.setDateFormatString("dd/MM/yyyy");
		editor.setFocusLostBehavior(JFormattedTextField.PERSIST);

		Box boxHorizontalTipoExame = Box.createHorizontalBox();
		boxVerticalCadastrarAgenda.add(boxHorizontalTipoExame);

		JLabel labelTipoExame = new JLabel("Tipo de Exame:");
		labelTipoExame.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalTipoExame.add(labelTipoExame);

		JLabel labelInfo_8 = new JLabel("*");
		labelInfo_8.setForeground(Color.RED);
		labelInfo_8.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalTipoExame.add(labelInfo_8);

		Component horizontal_cadastraragenda_8 = Box.createHorizontalStrut(8);
		boxHorizontalTipoExame.add(horizontal_cadastraragenda_8);

		comboBoxTipoExame.setModel(new DefaultComboBoxModel<Object>(EnumExame.values()));
		comboBoxTipoExame.setSelectedIndex(0);
		boxHorizontalTipoExame.add(comboBoxTipoExame);

		Component vertical_cadastraragenda_6 = Box.createVerticalStrut(32);
		boxVerticalCadastrarAgenda.add(vertical_cadastraragenda_6);

		Box boxHorizontalHorarioExame = Box.createHorizontalBox();
		boxVerticalCadastrarAgenda.add(boxHorizontalHorarioExame);

		JLabel labelHorarioExame = new JLabel("Horário do Exame:");
		labelHorarioExame.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalHorarioExame.add(labelHorarioExame);

		JLabel labelInfo_7 = new JLabel("*");
		labelInfo_7.setForeground(Color.RED);
		labelInfo_7.setFont(new Font("Verdana", Font.BOLD, 16));
		boxHorizontalHorarioExame.add(labelInfo_7);

		Component horizontal_cadastraragenda_7 = Box.createHorizontalStrut(8);
		boxHorizontalHorarioExame.add(horizontal_cadastraragenda_7);

		comboBoxHorarioExame.setFont(new Font("Verdana", Font.PLAIN, 12));
		boxHorizontalHorarioExame.add(comboBoxHorarioExame);

		populateHorarioExame(comboBoxHorarioExame);

		Box boxHorizontalAcao = Box.createHorizontalBox();
		boxHorizontalAcao.setAlignmentY(0.5f);
		boxHorizontalAcao.setBounds(10, 570, 740, 32);
		add(boxHorizontalAcao);

		Box boxHorizontalVoltar = Box.createHorizontalBox();
		boxHorizontalVoltar.setAlignmentY(0.5f);
		boxHorizontalAcao.add(boxHorizontalVoltar);

		Component horizontal_glue_cadastraragenda_2 = Box.createHorizontalGlue();
		boxHorizontalAcao.add(horizontal_glue_cadastraragenda_2);

		Box boxHorizontalCancelarEProximo = Box.createHorizontalBox();
		boxHorizontalAcao.add(boxHorizontalCancelarEProximo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agendaPanel.switchToCancelTab();
			}
		});
		boxHorizontalCancelarEProximo.add(btnCancelar);

		Component horizontal_acao_2 = Box.createHorizontalStrut(8);
		boxHorizontalCancelarEProximo.add(horizontal_acao_2);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LocalDate dia = textDataExame.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
					String horarioStr = (String) comboBoxHorarioExame.getSelectedItem();
					LocalTime horario = LocalTime.parse(horarioStr);
					LocalDateTime dataEhorario = LocalDateTime.of(dia, horario);
					agendamentoDTO.setDataEhorario(dataEhorario);
					agendamentoDTO.setTipoExame(comboBoxTipoExame.getSelectedIndex());
					agendamentoDTO.setMedicoSolicitante(textMedicoSolicitante.getText());

					PacienteController pacienteController = new PacienteController();
					List<Paciente> paciente = pacienteController.searchByField("cpf", textCpf.getText());

					if (paciente.isEmpty())
						JOptionPane.showConfirmDialog(null, "Nenhum Paciente com esses dados foi encontrado", "Erro",
								JOptionPane.DEFAULT_OPTION);
					else {
						int id = paciente.get(0).getId();
						agendamentoDTO.setPaciente_id(id + 1);
					}

					agendamentoController.create(agendamentoDTO);

					String mensagem = String.format("Exame de %s agendado com sucesso!",
							comboBoxTipoExame.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null, mensagem, "Sucesso", JOptionPane.INFORMATION_MESSAGE);

					agendaPanel.switchToBackTab();
				} catch (Exception a) {
					System.out.println("Error: " + a.getMessage());
					JOptionPane.showMessageDialog(null, agendaPanel.errorMessage());
				}
			}
		});
		boxHorizontalCancelarEProximo.add(btnCadastrar);
	}

	private void populateHorarioExame(JComboBox<String> comboBox) {
		List<String> horarios = getHorariosDisponiveis();
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(horarios.toArray(new String[0]));
		comboBox.setModel(model);
	}

	private List<String> getHorariosDisponiveis() {
		List<String> horarios = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

		LocalTime startTime = LocalTime.of(9, 0);
		LocalTime endTime = LocalTime.of(17, 0); // Modifica os horários de atendimento
		while (startTime.isBefore(endTime) || startTime.equals(endTime)) {
			horarios.add(startTime.format(formatter));
			startTime = startTime.plusMinutes(30);
		}
		return horarios;
	}
}
