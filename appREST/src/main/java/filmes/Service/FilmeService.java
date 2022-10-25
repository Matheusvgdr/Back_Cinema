package filmes.Service;

import java.util.List;

import filmes.DAO.FilmeDAO;
import filmes.Model.Filme;

public class FilmeService {
	
	FilmeDAO dao = new FilmeDAO();
	
	public boolean deletar(String id) {
		return dao.deletarFilme(Integer.parseInt(id));  
	}
	
	public boolean inserir(Filme filme){
		return dao.inserirFilme(filme);
	}
	
	public Filme procurarId(int id) {
		return dao.procurarPorId(id);
	}
	
	public List<Filme> litarFilmes(){
		return dao.listarFilmes();
	}
}
