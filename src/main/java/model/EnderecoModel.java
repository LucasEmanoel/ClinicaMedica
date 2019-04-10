package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Endereco;
import model.exceptions.ClinicaMedicaException;

public class EnderecoModel {

	Dao<Endereco> dao = new DaoImpl<Endereco>();  
	
	public void registrarEndereco(Endereco obj) throws Exception{
		
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new ClinicaMedicaException("Erro ao registrar Endereco.");
		}
	}
	
	public void removerEndereco(Endereco obj) throws Exception{
		
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao deletar Endereco.");
		}
	}
	
	public void atualizarEndereco(Endereco obj) throws Exception{
		
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao atualizar Endereco.");
		}
	}
	public void encontrarEnderecoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Endereco.class, id);
		}else {
			throw new ClinicaMedicaException("Erro ao encotrar Endereco.");
		}
	}
}
