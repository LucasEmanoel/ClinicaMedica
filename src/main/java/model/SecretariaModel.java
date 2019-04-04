package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Secretaria;

public class SecretariaModel {
	Dao<Secretaria> dao = new DaoImpl<Secretaria>(Secretaria.class);  
	
	public void registrarSecretaria(Secretaria obj) throws Exception{
		
		Secretaria aux = (Secretaria) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao registrar secretaria.");
		}
	}
	
	public void removerSecretaria(Secretaria obj) throws Exception{
		
		Secretaria aux = (Secretaria) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao deletar secretaria.");
		}
	}
	
	public void atualizarSecretaria(Secretaria obj) throws Exception{
		
		Secretaria aux = (Secretaria) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar secretaria.");
		}
	}
	public void encontrarSecretariaPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro encontrar secretaria.");
		}
	}
}
