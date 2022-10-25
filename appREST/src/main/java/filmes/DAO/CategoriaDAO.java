package filmes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import filmes.Model.Categoria;

public class CategoriaDAO {
	
	Connection conex = null;
	
	public boolean inserirCategoria(Categoria categ) {
		
		boolean resultado = true;
		int returnQuery;
		
		conex = DAO.criarConexao();
		
		String  sql = "INSERT INTO tb_categorias(titulo, imagePath) VALUES(?, ?);";
		
		try {
		PreparedStatement ps = conex.prepareStatement(sql);
		
		ps.setString(1, categ.getNome() );
		ps.setString(2, categ.getImagePath());
		
		returnQuery = ps.executeUpdate();
		
		if (returnQuery < 0 ) {
			resultado = false;
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
		//"INSERT INTO tb_filmes (descricao, duracao, ano, indicacao, imagePath, categoriaId) VALUES (?, ? ,?, ?, ?, ?)";
	}

	public Categoria procurarPorId(int id) {
		Categoria cat = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_categorias WHERE id=?";
		
		try {
		PreparedStatement ps = conex.prepareStatement(sql);
		ps.setInt(1, id);
		
		while (rs.next()) {
			cat = new Categoria();
			
			cat.setId(rs.getInt("id"));
			cat.setNome(rs.getString("nome"));
			cat.setImagePath(rs.getString("imagePath"));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return cat;
	}
	
	public boolean deletarCategoria(int id) {
		
		boolean resultado = true;
		int returnQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "DELETE FROM tb_categorias WHERE id = ?";
		
		try {
		PreparedStatement ps = conex.prepareStatement(sql);
		
		ps.setInt(1, id);
		
		returnQuery = ps.executeUpdate();
		
		if (returnQuery < 0 ) {
			resultado = false;
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	public List<Categoria> listarCategorias() {
		
		List<Categoria> listaDeCategorias = new ArrayList<Categoria>();
		ResultSet rs = null;
		Categoria ctg = null;
		
		String sql = "SELECT * FROM tb_categorias;";
		
		try {
		PreparedStatement ps = conex.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			ctg = new Categoria();
			
			ctg.setId(rs.getInt("id"));
			ctg.setNome(rs.getString("nome"));
			ctg.setImagePath(rs.getString("imagePath"));
			
			listaDeCategorias.add(ctg);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeCategorias;
	}
}