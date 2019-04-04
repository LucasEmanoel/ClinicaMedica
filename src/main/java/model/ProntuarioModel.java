package model;

import java.util.Date;
import java.util.List;

import model.dao.Dao;
import model.dao.ProntuarioDao;
import model.entidades.Prontuario;

public class ProntuarioModel {
	Dao<Prontuario> dao = new ProntuarioDao();  
	
	public void registrarProntuario(Prontuario obj) throws Exception{
		
		Prontuario aux = (Prontuario) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro ao registrar prontuario.");
		}
	}
	
	public void removerProntuario(Prontuario obj) throws Exception{
		
		Prontuario aux = (Prontuario) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro ao deletar prontuario.");
		}
	}
	
	public void atualizarProntuario(Prontuario obj) throws Exception{
		
		Prontuario aux = (Prontuario) dao.encontrar(obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro ao atualizar prontuario.");
		}
	}
	public void encontrarProntuarioPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		}else {
			throw new Exception("Erro ao encontrar prontuario.");
		}
	}
	public List<Prontuario> findProntuariosPorId(Long id) throws Exception{
		
		ProntuarioDao newDao = (ProntuarioDao) dao;
		
		if(id != null) { 
			return newDao.findProntuarioPorIdCliente(id);
		}else {
			throw new Exception("Erro ao listar prontuarios por ID Cliente.");
		}
	}
	public List<Prontuario> findProntuariosPorData(Date data) throws Exception{
		
		ProntuarioDao newDao = (ProntuarioDao) dao;
		
		if(data != null) {
			return newDao.findProntuarioPorData(data);
		}else {
			throw new Exception("Erro ao listar prontuarios por Data.");
		}
	}
}
