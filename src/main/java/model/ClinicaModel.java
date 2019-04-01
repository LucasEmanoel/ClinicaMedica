package model;

import model.dao.ClinicaDao;
import model.dao.Dao;
import model.entidades.Clinica;

public class ClinicaModel {
	Dao<Clinica> dao = new ClinicaDao();  
	
	public void registrarClinica(Clinica obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerClinica(Clinica obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarClinica(Clinica obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void findClinica(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
