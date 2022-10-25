package filmes.appREST;

import java.sql.Connection;

import filmes.DAO.DAO;

public class App {

	public static void main(String[] args) {
		
		Connection conex;
		
		conex = DAO.criarConexao();

	}

}
