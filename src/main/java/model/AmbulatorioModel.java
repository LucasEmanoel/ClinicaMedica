package model;

import model.dao.AmbulatorioDao;
import model.dao.Dao;
import model.entidades.Ambulatorio;

public class AmbulatorioModel {
	
	Dao<Ambulatorio> dao = new AmbulatorioDao();  
	
	public void registrarAmbulatorio(Ambulatorio obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerAmbulatorio(Ambulatorio obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarAmbulatorio(Ambulatorio obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findAmbulatorio(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
