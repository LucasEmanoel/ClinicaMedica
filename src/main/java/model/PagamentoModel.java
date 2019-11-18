package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Pagamento;
import model.exceptions.ClinicaMedicaException;

public class PagamentoModel {
	Dao<Pagamento> dao = new DaoImpl<Pagamento>();

	public void registrarPagamento(Pagamento obj) throws Exception {

		if (obj.getValor() != null && obj.getValor() > 0) {
			dao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao realizar pagamento.");
		}
	}

	public void removerPagamento(Pagamento obj) throws Exception {

		Pagamento aux = (Pagamento) dao.encontrar(Pagamento.class, obj.getId());

		if (obj == aux) {
			dao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao deletar pagamento.");
		}
	}

	public void atualizarPagamento(Pagamento obj) throws Exception {

		Pagamento aux = (Pagamento) dao.encontrar(Pagamento.class, obj.getId());

		if (obj == aux) {
			dao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar pagamento.");
		}
	}

	public void encontrarPagamentoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Pagamento.class, id);
		} else {
			throw new ClinicaMedicaException("Erro ao encontrar pagamento.");
		}
	}
}
