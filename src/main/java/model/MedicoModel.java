package model;

import model.dao.Dao;
import model.dao.MedicoDao;
import model.entidades.Medico;

public class MedicoModel {
	Dao<Medico> dao = new MedicoDao();  
	
	public void registrarMedico(Medico obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerMedico(Medico obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarMedico(Medico obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findMedico(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
