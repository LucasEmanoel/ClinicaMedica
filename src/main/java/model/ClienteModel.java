package model;

import model.dao.Dao;
import model.dao.PessoaDao;
import model.entidades.Cliente;
import model.entidades.Pessoa;
import model.exceptions.ClinicaMedicaException;

public class ClienteModel {
	
	Dao<Pessoa> dao = new PessoaDao();  
	
	public void registrarCliente(Cliente obj) throws Exception{
		
		PessoaDao newDao = (PessoaDao) dao;
		Cliente cli = (Cliente) newDao.encontrarPorCpf(obj.getCpf());
		
		if (
			obj.getNome() != null && obj.getCpf() != null && obj.getRg() != null && obj.getIdade() > 0 &&
			obj.getEmail() != null && obj.getSenha() != null && !(obj.equals(cli)) 
			) {
			dao.salvar(obj);
		}else{
			throw new ClinicaMedicaException("Erro ao registrar cliente.");
		}
	}
	
	public void removerCliente(Cliente obj) throws Exception{
		
		PessoaDao newDao = (PessoaDao) dao;
		Cliente aux = (Cliente) newDao.encontrarPorCpf(obj.getCpf());
		
		if (obj.equals(aux)){
			newDao.deletar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao remover cliente.");
		}
	}
	
	public void atualizarCliente(Cliente obj) throws Exception{
		
		PessoaDao newDao = (PessoaDao) dao;
		Cliente aux = (Cliente) newDao.encontrarPorCpf(obj.getCpf());
		
		if (obj.equals(aux)) {
			newDao.atualizar(obj);
		}else {
			throw new ClinicaMedicaException("Erro ao atualizar cliente.");
		}
	}
	public Cliente encontrarClientePorId(Long id) throws Exception {
		if (id != null) {
			return (Cliente) dao.encontrar(Pessoa.class, id);
		}else {
			throw new ClinicaMedicaException("Erro ao encontrar cliente.");
		}
	}
}