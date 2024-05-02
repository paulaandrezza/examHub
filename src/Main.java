import java.util.Date;

import model.entities.Convenio;
import model.entities.Endereco;
import model.entities.HistoricoMedico;
import model.entities.Paciente;
import model.entities.Pessoa;
import model.enums.Genero;
import model.persistence.DatabaseConnection;
import model.persistence.dao.paciente.PacienteDAO;
import view.TelaCadastroPaciente;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.connectAndExecute();
        
       PacienteDAO pacienteDao = new PacienteDAO();
       System.out.println(pacienteDao.getAll());
       
       Endereco endereco = new Endereco(
               123456,
               "SP",
               "São Paulo",
               "Centro",
               "Rua A",
               "100",
               "Apt 101"
           );
       
       Pessoa pessoa = new Pessoa(
               "João Silva",
               "123.456.789-00",
               new Date(),
               11987654321L,
               1132109876L,
               "joao@example.com",
               Genero.MASCULINO,
               endereco
           );
       
       Convenio convenio = new Convenio(
               987654321,
               "Saúde Plena",
               "Plano Premium"
           );

           HistoricoMedico historicoMedico = new HistoricoMedico(
               "Nenhum", 
               "Paracetamol",
               "Tomar 1 vez ao dia"
           );
           
       Paciente paciente = new Paciente(
               1.75f,
               false,
               false,
               convenio,
               historicoMedico,
               pessoa
           );
       
       pacienteDao.save(endereco, convenio, historicoMedico, pessoa, paciente);
       System.out.println(pacienteDao.getAll());

       javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               TelaCadastroPaciente tela = new TelaCadastroPaciente();
               tela.setVisible(true);
           }
       });
	}

}
