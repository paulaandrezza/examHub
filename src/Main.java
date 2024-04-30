import model.persistence.DatabaseConnection;
import model.persistence.dao.EnderecoDAO;

public class Main {

	public static void main(String[] args) {
		DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.connectAndExecute();
        
        EnderecoDAO end = new EnderecoDAO();
        System.out.println(end.getAll());
        System.out.println(end.get(1));
	}

}
