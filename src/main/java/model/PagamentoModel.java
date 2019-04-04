package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Pagamento;

public class PagamentoModel {
	Dao<Pagamento> dao = new DaoImpl<Pagamento>(Pagamento.class);  
	
	public void registrarPagamento(Pagamento obj) throws Exception{
		
		Pagamento aux = (Pagamento) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao realizar pagamento.");
		}
	}
	
	public void removerPagamento(Pagamento obj) throws Exception{
		
		Pagamento aux = (Pagamento) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao deletar pagamento.");
		}
	}
	
	public void atualizarPagamento(Pagamento obj) throws Exception{
		
		Pagamento aux = (Pagamento) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar pagamento.");
		}
	}
	public void encontrarPagamentoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao encontrar pagamento.");
		}
	}
}
