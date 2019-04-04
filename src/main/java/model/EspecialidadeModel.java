package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Especialidade;

public class EspecialidadeModel {
	Dao<Especialidade> dao = new DaoImpl<Especialidade>(Especialidade.class);  
	
	public void registrarEspecialidade(Especialidade obj) throws Exception{
		
		Especialidade aux = (Especialidade) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao registrar especialidade.");
		}
	}
	
	public void removerEspecialidade(Especialidade obj) throws Exception{
		
		Especialidade aux = (Especialidade) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao deletar especialidade.");
		}
	}
	
	public void atualizarEspecialidade(Especialidade obj) throws Exception{
		
		Especialidade aux = (Especialidade) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar especialidade.");
		}
	}
	public void encontrarEspecialidadePorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao encotrar especialidade.");
		}
	}
}
