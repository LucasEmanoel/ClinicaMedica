package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Medicamento;

public class MedicamentoModel {
	Dao<Medicamento> dao = new DaoImpl<Medicamento>();  
	
	public void registrarMedicamento(Medicamento obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerMedicamento(Medicamento obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarMedicamento(Medicamento obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findMedicamento(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
