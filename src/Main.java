import javax.swing.JOptionPane;

import model.entities.Endereco;
import model.exceptions.EntityNotFoundException;
import model.persistence.DatabaseConnection;
import model.persistence.dao.EnderecoDAO;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.connectAndExecute();
        
        EnderecoDAO end = new EnderecoDAO();

        Endereco end3 = new Endereco(12365444, "MG", "Três Corações", "Centro", "Rua do amor", "123-A", null);
        int id = end.save(end3);
        System.out.println(end.getAll());
        end.delete(id);
        System.out.println(end.getAll());
        
        try {
            System.out.println(end.get(1));
        	Endereco endeee = end.get(100);
        } catch (EntityNotFoundException e) {
        	JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Erro de acesso ao banco de dados: " + e.getMessage(), "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        
        System.out.println(end.getAll());
        
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TelaCadastroPaciente tela = new TelaCadastroPaciente();
                tela.setVisible(true);
            }
        });

	}

}
