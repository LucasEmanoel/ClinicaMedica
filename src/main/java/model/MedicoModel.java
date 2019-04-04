package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Medico;

public class MedicoModel {
	Dao<Medico> dao = new DaoImpl<Medico>(Medico.class);  
	
	public void registrarMedico(Medico obj) throws Exception{
		
		Medico aux = (Medico) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao registrar medico.");
		}
	}
	
	public void removerMedico(Medico obj) throws Exception{
		
		Medico aux = (Medico) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao remover medico.");
		}
	}
	
	public void atualizarMedico(Medico obj) throws Exception{
		
		Medico aux = (Medico) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar medico.");
		}
	}
	public void encontrarMedicoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao encontrar medico.");
		}
	}
}
