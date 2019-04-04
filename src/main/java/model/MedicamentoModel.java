package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Medicamento;

public class MedicamentoModel {
	Dao<Medicamento> dao = new DaoImpl<Medicamento>(Medicamento.class);  
	
	public void registrarMedicamento(Medicamento obj) throws Exception{
		
		Medicamento aux = (Medicamento) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao registrar medicamento.");
		}
	}
	
	public void removerMedicamento(Medicamento obj) throws Exception{
		
		Medicamento aux = (Medicamento) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao remover medicamento.");
		}
	}
	
	public void atualizarMedicamento(Medicamento obj) throws Exception{
		
		Medicamento aux = (Medicamento) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar medicamento.");
		}
	}
	public void encontrarMedicamentoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao atualizar medicamento.");
		}
	}
}
