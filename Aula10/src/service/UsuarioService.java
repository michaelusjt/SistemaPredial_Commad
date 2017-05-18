package service;

import java.util.List;

import dao.UsuarioDAO;
import model.Empresa;
import model.Usuario;
import model.Usuario;


public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public int criar(Usuario usuario) {
		return dao.criar(usuario);
	}
	
	public void atualizar(Usuario usuario){
		dao.atualizar(usuario);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Usuario carregar(int id){
		return dao.carregar(id);
	}
	
	public List<Usuario> carregarTodosUsuarios(){
		return dao.carregarTodosUsuarios();
	}

}
