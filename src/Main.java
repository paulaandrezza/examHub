import model.entities.Endereco;
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
        
        System.out.println(end.get(1));

	}

}
