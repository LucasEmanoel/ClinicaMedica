package model;

import model.dao.ClienteDao;
import model.dao.Dao;
import model.entidades.Cliente;

public class ClienteModel {
	
	Dao<Cliente> dao = new ClienteDao();  
	
	public void registrarCliente(Cliente obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerCliente(Cliente obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarCliente(Cliente obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findCliente(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
}