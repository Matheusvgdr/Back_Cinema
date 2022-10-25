package filmes.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection criarConexao() {
		String dataBase, url, user, password, server;
		
		Connection cnx = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		server = "localhost:3306";
		dataBase = "db_filmes";
		user = "root";
		password = "";
		url = "jdbc:mysql://" + server + "/" + dataBase;
		
		try {
			
			cnx = DriverManager.getConnection(url);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		return cnx;
	}
	

}
