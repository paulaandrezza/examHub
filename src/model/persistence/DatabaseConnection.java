package model.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

	public void connectAndExecute() {
		Connection connection = null;
		
		try {
		    connection = getConnection();
		    Statement statement = connection.createStatement();
		    
		    String create_tables = new String(Files.readAllBytes(Paths.get("resources/sql/create_tables.sql")));
		    statement.executeUpdate(create_tables);
		    
		    ResultSet rs = statement.executeQuery("SELECT COUNT(*) AS rowcount FROM Pessoa");
		      rs.next();
		      int count = rs.getInt("rowcount");
		      if (count == 0) {
		        String insert_data = new String(Files.readAllBytes(Paths.get("resources/sql/insert_data.sql")));
		        statement.executeUpdate(insert_data);	        	
		      }
		    
		    System.out.println("Tabelas criadas com sucesso.");
		} catch (SQLException | IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:sqlite:./examHub.db");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
	public static String loadSQL(String filePath) {
        try {
            Path path = Paths.get(filePath);
            return new String(Files.readAllBytes(path));
        } catch (IOException e) {
            System.err.println("Erro ao carregar SQL do arquivo " + filePath + ": " + e.getMessage());
            return "";
        }
    }
}
