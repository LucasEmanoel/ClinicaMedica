package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Encaminhamento;

public class EncaminhamentoModel {
	Dao<Encaminhamento> dao = new DaoImpl<Encaminhamento>(Encaminhamento.class);  
	
	public void registrarEncaminhamento(Encaminhamento obj) throws Exception{
		
		Encaminhamento aux = (Encaminhamento) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao criar encaminhamento.");
		}
	}
	
	public void removerEncaminhamento(Encaminhamento obj) throws Exception{
		
		Encaminhamento aux = (Encaminhamento) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao deletar encaminhamento.");
		}
	}
	
	public void atualizarEncaminhamento(Encaminhamento obj) throws Exception{
		
		Encaminhamento aux = (Encaminhamento) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar encaminhamento.");
		}
	}
	public void encontrarEncaminhamentoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro encontrar encaminhamento.");
		}
	}
}
