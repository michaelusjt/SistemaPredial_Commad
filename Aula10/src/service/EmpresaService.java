package service;

import java.util.List;

import dao.EmpresaDAO;
import model.Empresa;



public class EmpresaService {

	EmpresaDAO dao = new EmpresaDAO();

	public int criar(Empresa empresa) {
		return dao.criar(empresa);
	}

	public void atualizar(Empresa empresa) {
		dao.atualizar(empresa);
	}

	public void excluir(int id) {
		dao.excluir(id);
	}

	public Empresa carregar(int id) {
		return dao.carregar(id);
	}
	
}
