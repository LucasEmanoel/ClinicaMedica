package model;

import model.dao.Dao;
import model.dao.SecretariaDao;
import model.entidades.Secretaria;

public class SecretariaModel {
	Dao<Secretaria> dao = new SecretariaDao();  
	
	public void registrarSecretaria(Secretaria obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerSecretaria(Secretaria obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarSecretaria(Secretaria obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findSecretaria(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
