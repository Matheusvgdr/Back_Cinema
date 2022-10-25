package filmes.Service;

import java.util.List;

import filmes.DAO.CategoriaDAO;
import filmes.Model.Categoria;

public class CategoriaService {
	
	CategoriaDAO dao= new CategoriaDAO();
	
	public boolean deletar(String id) {
		return dao.deletarCategoria(Integer.parseInt(id));  
	}
	
	public boolean inserir(Categoria cat){
		return dao.inserirCategoria(cat);
	}
	
	public Categoria procurarId(int id) {
		return dao.procurarPorId(id);
	}
	
	public List<Categoria> litarCategorias(){
		return dao.listarCategorias();
	}
}
