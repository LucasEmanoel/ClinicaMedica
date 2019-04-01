package model;

import model.dao.ClinicaDao;
import model.dao.Dao;
import model.dao.EspecialidadeDao;
import model.entidades.Especialidade;

public class EspecialidadeModel {
	Dao<Especialidade> dao = new EspecialidadeDao();  
	
	public void registrarEspecialidade(Especialidade obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerEspecialidade(Especialidade obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarEspecialidade(Especialidade obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findEspecialidade(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
