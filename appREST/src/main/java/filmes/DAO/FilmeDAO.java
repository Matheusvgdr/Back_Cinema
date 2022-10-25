package filmes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import filmes.Model.Filme;

public class FilmeDAO {
	
	Connection conex = null;
	
	public boolean inserirFilme(Filme filme) {
		
		boolean resultado = true;
		int returnQuery;
		
		conex = DAO.criarConexao();
		
		String  sql = "INSERT INTO tb_filmes (descricao, duracao, ano, indicacao, imagePath, categoriaId) VALUES (?, ? ,?, ?, ?, ?)";
		
		try {
		PreparedStatement ps = conex.prepareStatement(sql);
		
		ps.setString(1, filme.getDescricao());
		ps.setString(2, filme.getDuracao());
		ps.setString(3, filme.getAno());
		ps.setString(4, filme.getIndicacao());
		ps.setString(5, filme.getImagePath());
		ps.setInt(6, filme.getCategoriaId().getId());
		
		returnQuery = ps.executeUpdate();
		
		if (returnQuery < 0 ) {
			resultado = false;
		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	public Filme procurarPorId(int id) {
		Filme filme = null;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_filmes WHERE id=?";
		
		try {
		PreparedStatement ps = conex.prepareStatement(sql);
		ps.setInt(1, id);
		
		while (rs.next()) {
			filme = new Filme();
			
			filme.setId(rs.getInt("id"));
			filme.setDescricao(rs.getString("descricao"));
			filme.setDuracao(rs.getString("duracao"));
			filme.setAno(rs.getString("ano"));
			filme.setIndicacao(rs.getString("indicacao"));
			filme.setImagePath(rs.getString("imagePath"));
			filme.getCategoriaId().setId(rs.getInt("categoriaId"));
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filme;
	}
	
	public boolean deletarFilme(int id) {
		
		boolean resultado = true;
		int returnQuery;
		
		conex = DAO.criarConexao();
		
		String sql = "DELETE FROM tb_filmes WHERE id = ?";
		
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

	public List<Filme> listarFilmes() {
		
		List<Filme> listaDeFilmes = new ArrayList<Filme>();
		ResultSet rs = null;
		Filme filme = null;
		
		String sql = "SELECT * FROM tb_filmes;";
		
		try {
		PreparedStatement ps = conex.prepareStatement(sql);
		
		rs = ps.executeQuery();
		
		while(rs.next()) {
			filme = new Filme();
			
			filme.setId(rs.getInt("id"));
			filme.setDescricao(rs.getString("descricao"));
			filme.setDuracao(rs.getString("duracao"));
			filme.setAno(rs.getString("ano"));
			filme.setIndicacao(rs.getString("indicacao"));
			filme.setImagePath(rs.getString("imagePath"));
			filme.getCategoriaId().setId(rs.getInt("categoriaId"));
			
			listaDeFilmes.add(filme);
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaDeFilmes;
	}
}
