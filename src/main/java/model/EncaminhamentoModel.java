package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Encaminhamento;
import model.exceptions.ClinicaMedicaException;

public class EncaminhamentoModel {
	Dao<Encaminhamento> dao = new DaoImpl<Encaminhamento>();  
	
	public void registrarEncaminhamento(Encaminhamento obj) throws Exception{
		
		Encaminhamento aux = (Encaminhamento) dao.encontrar(Encaminhamento.class, obj.getId());
		
		if (obj.getDescricao() != null && obj != aux) {
			dao.salvar(obj);
		}else{
			throw new ClinicaMedicaException("Erro ao criar encaminhamento.");
		}
	}
	
	public void removerEncaminhamento(Encaminhamento obj) throws Exception{
		
		Encaminhamento aux = (Encaminhamento) dao.encontrar(Encaminhamento.class, obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao deletar encaminhamento.");
		}
	}
	
	public void atualizarEncaminhamento(Encaminhamento obj) throws Exception{
		
		Encaminhamento aux = (Encaminhamento) dao.encontrar( Encaminhamento.class, obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao atualizar encaminhamento.");
		}
	}
	public void encontrarEncaminhamentoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Encaminhamento.class, id);
		}else {
			throw new ClinicaMedicaException("Erro encontrar encaminhamento.");
		}
	}
}
