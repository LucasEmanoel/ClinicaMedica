package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Clinica;

public class ClinicaModel {
	Dao<Clinica> dao = new DaoImpl<Clinica>(Clinica.class);  
	
	public void registrarClinica(Clinica obj) throws Exception{
		
		Clinica aux = (Clinica) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao cadastrar clinica.");
		}
	}
	
	public void removerClinica(Clinica obj) throws Exception{
		
		Clinica aux = (Clinica) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao remover clinica.");
		}
	}
	
	public void atualizarClinica(Clinica obj) throws Exception{
		
		Clinica aux = (Clinica) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar clinica.");
		}
	}
	public void encontrarClinicaPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao encontrar clinica.");
		}
	}
}
