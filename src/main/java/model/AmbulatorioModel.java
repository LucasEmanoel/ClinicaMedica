package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Ambulatorio;

public class AmbulatorioModel {
	
	Dao<Ambulatorio> dao = new DaoImpl<Ambulatorio>(Ambulatorio.class);  
	
	public void registrarAmbulatorio(Ambulatorio obj) throws Exception{
		
		Ambulatorio aux = (Ambulatorio) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao registrar ambulatorio.");
		}
	}
	
	public void removerAmbulatorio(Ambulatorio obj) throws Exception{
		
		Ambulatorio aux = (Ambulatorio) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao deletar ambulatorio.");
		}
	}
	
	public void atualizarAmbulatorio(Ambulatorio obj) throws Exception{
		
		Ambulatorio aux = (Ambulatorio) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar ambulatorio.");
		}
	}
	
	public void encontrarAmbulatorioPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao encontrar ambulatorio.");
		}
	}
}
