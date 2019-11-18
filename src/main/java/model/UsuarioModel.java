package model;

import model.dao.ClinicaDao;
import model.dao.Dao;
import model.dao.PessoaDao;
import model.entidades.Clinica;
import model.entidades.Pessoa;
import model.exceptions.ClinicaMedicaException;

public class UsuarioModel {
	
	Dao<Pessoa> dao = new PessoaDao();
	Dao<Clinica> dao2 = new ClinicaDao();
	
	public Object logar(String email, String senha) throws ClinicaMedicaException {
		PessoaDao newDao = (PessoaDao) dao;
		ClinicaDao newDao2 = (ClinicaDao) dao2;
		
		if (email != null && senha != null) {
			
			Pessoa pessoa = newDao.getUsuario(email, senha);
			Clinica clinica = newDao2.getUsuario(email, senha);
			
			if(pessoa != null) {
				return pessoa;
			}else if(clinica != null){
				return clinica;
			}else {
				return "Email ou Senha inválidos!!";
			}
		} else {
			throw new ClinicaMedicaException("erro ao logar.");
		}
	}
}