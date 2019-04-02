package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Encaminhamento;

public class EncaminhamentoModel {
	Dao<Encaminhamento> dao = new DaoImpl<Encaminhamento>();  
	
	public void registrarEncaminhamento(Encaminhamento obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerEncaminhamento(Encaminhamento obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarCliente(Encaminhamento obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findEncaminhamento(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
