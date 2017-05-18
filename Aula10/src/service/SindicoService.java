package service;

import java.util.ArrayList;


import model.Empresa;
import dao.EmpresaDAO;

public class SindicoService {
	EmpresaDAO dao;
	
	public SindicoService(){
		dao = new EmpresaDAO();
	}
	public ArrayList<Empresa> listarEmpresas(){
		return dao.listarEmpresas();
	}
	public ArrayList<Empresa> listarEmpresas(String chave){
		return dao.listarEmpresas(chave);
	}
	

}
