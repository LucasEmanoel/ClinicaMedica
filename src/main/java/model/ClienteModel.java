package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Cliente;

public class ClienteModel {
	
	Dao<Cliente> dao = new DaoImpl<Cliente>(Cliente.class);  
	
	public void registrarCliente(Cliente obj) throws Exception{
		
		Cliente aux = (Cliente) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao registrar cliente.");
		}
	}
	
	public void removerCliente(Cliente obj) throws Exception{
		
		Cliente aux = (Cliente) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao remover cliente.");
		}
	}
	
	public void atualizarCliente(Cliente obj) throws Exception{
		Cliente aux = (Cliente) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar cliente.");
		}
	}
	public void encontrarClientePorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao encontrar cliente.");
		}
	}
}