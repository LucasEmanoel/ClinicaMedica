package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Pagamento;

public class PagamentoModel {
	Dao<Pagamento> dao = new DaoImpl<Pagamento>();  
	
	public void registrarPagamento(Pagamento obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerPagamento(Pagamento obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarPagamento(Pagamento obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findPagamento(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
