package model;

import model.dao.Dao;
import model.dao.PessoaDao;
import model.entidades.Funcionario;
import model.entidades.Pessoa;
import model.exceptions.ClinicaMedicaException;

public class FuncionarioModel {
	
	Dao<Pessoa> dao = new PessoaDao();
	
	public void atualizarFuncionario(Funcionario f) throws Exception {
		Pessoa comparador = (Pessoa) f;
		Pessoa a = dao.encontrar(Pessoa.class, f.getId());
		
		if(comparador != null && a.equals(f)) {
			dao.atualizar(comparador);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar funcionario..");
		}
		
	}
	public void deletarFuncionario(Funcionario f) throws Exception {
		Pessoa func = (Pessoa) f;
		Pessoa comparador = dao.encontrar(Pessoa.class, f.getId());
		
		if(func != null && comparador.equals(func)) {
			dao.deletar(func);
		} else {
			throw new ClinicaMedicaException("Erro ao deletar funcionario..");
		}
		
	}
}
