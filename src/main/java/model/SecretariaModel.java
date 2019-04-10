package model;

import model.dao.Dao;
import model.dao.DaoImpl;
import model.entidades.Secretaria;
import model.exceptions.ClinicaMedicaException;

public class SecretariaModel {
	Dao<Secretaria> dao = new DaoImpl<Secretaria>();  
	
	public void registrarSecretaria(Secretaria obj) throws Exception{
		
		Secretaria aux = (Secretaria) dao.encontrar(Secretaria.class, obj.getId());
		
		if (obj.getNome() != null && obj.getCpf() != null && obj.getRg() != null && 
			obj.getEmail() != null && obj.getSenha() != null && obj.getSalario() != null &&
			obj.getIdade() > 0 && obj.getQualificacao() != null && obj.getClinica() != null && obj != aux) {
			dao.salvar(obj);
		}else{
			throw new ClinicaMedicaException("Erro ao registrar secretaria.");
		}
	}
	
	public void removerSecretaria(Secretaria obj) throws Exception{
		
		Secretaria aux = (Secretaria) dao.encontrar(Secretaria.class, obj.getId());
		
		if (obj == aux) {
			dao.deletar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao deletar secretaria.");
		}
	}
	
	public void atualizarSecretaria(Secretaria obj) throws Exception{
		
		Secretaria aux = (Secretaria) dao.encontrar(Secretaria.class, obj.getId());
		
		if (obj == aux) {
			dao.atualizar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao atualizar secretaria.");
		}
	}
	public void encontrarSecretariaPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Secretaria.class, id);
		}else {
			throw new ClinicaMedicaException("Erro encontrar secretaria.");
		}
	}
}
