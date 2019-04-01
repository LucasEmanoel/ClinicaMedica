package model;

import java.util.Date;
import java.util.List;

import model.dao.Dao;
import model.dao.ProntuarioDao;
import model.entidades.Prontuario;

public class ProntuarioModel {
	Dao<Prontuario> dao = new ProntuarioDao();  
	
	public void registrarProntuario(Prontuario obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerProntuario(Prontuario obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarProntuario(Prontuario obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public Prontuario findProntuario(Long id) throws Exception{
		if(id != null) {
			dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public List<Prontuario> findProntuarioPorCpf(String cpf) throws Exception{
		if(cpf != null) {
			return null;
		}else {
			throw new Exception("Erro!!");
		}
	}
	public List<Prontuario> findProntuarioPorData(Date data) throws Exception{
		if(data != null) {
			return null;
		}else {
			throw new Exception("Erro!!");
		}
	}
}
