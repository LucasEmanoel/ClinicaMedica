package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Medicamento;
import model.exceptions.ClinicaMedicaException;

public class MedicamentoModel {
	Dao<Medicamento> dao = new DaoImpl<Medicamento>();  
	
	public void registrarMedicamento(Medicamento obj) throws Exception{
		
		Medicamento aux = (Medicamento) dao.encontrar(Medicamento.class, obj.getId());
		
		if (
			obj.getDescricao() != null && obj.getQuantidade() > 0 &&
			obj.getProntuario() != null && obj != aux
			) {
			dao.salvar(obj);
		}else{
			throw new ClinicaMedicaException("Erro ao registrar medicamento.");
		}
	}
	
	public void removerMedicamento(Medicamento obj) throws Exception{
		
		Medicamento aux = (Medicamento) dao.encontrar(Medicamento.class, obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao remover medicamento.");
		}
	}
	
	public void atualizarMedicamento(Medicamento obj) throws Exception{
		
		Medicamento aux = (Medicamento) dao.encontrar(Medicamento.class, obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao atualizar medicamento.");
		}
	}
	public void encontrarMedicamentoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Medicamento.class, id);
		}else {
			throw new ClinicaMedicaException("Erro ao atualizar medicamento.");
		}
	}
}
