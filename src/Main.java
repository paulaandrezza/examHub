import model.persistence.DatabaseConnection;
import model.persistence.dao.paciente.PacienteDAO;
import view.TelaCadastroPaciente;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.connectAndExecute();
        
       PacienteDAO pacientedao = new PacienteDAO();
       System.out.print(pacientedao.getAll());

       javax.swing.SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               TelaCadastroPaciente tela = new TelaCadastroPaciente();
               tela.setVisible(true);
           }
       });
	}

}
