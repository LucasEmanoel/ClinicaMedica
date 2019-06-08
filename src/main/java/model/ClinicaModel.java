package model;

import java.util.List;

import model.dao.ClinicaDao;
import model.dao.Dao;
import model.dao.FuncionarioDao;
import model.entidades.Clinica;
import model.entidades.Funcionario;
import model.entidades.Medico;
import model.exceptions.ClinicaMedicaException;

public class ClinicaModel {
	Dao<Clinica> dao = new ClinicaDao();

	public void registrarClinica(Clinica obj) throws Exception {

		ClinicaDao newDao = (ClinicaDao) dao;
		Clinica aux = (Clinica) newDao.encontrarPorCnpj(obj.getCnpj());

		if (obj.getCnpj() != null && obj.getEmail() != null && obj.getSenha() != null && obj.getEndereco() != null
				&& !(obj.equals(aux))) {
			newDao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao cadastrar clinica.");
		}
	}

	public void removerClinica(Clinica obj) throws Exception {

		ClinicaDao newDao = (ClinicaDao) dao;
		Clinica aux = (Clinica) newDao.encontrarPorCnpj(obj.getCnpj());

		if (obj.equals(aux)) {
			newDao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao remover clinica.");
		}
	}

	public void atualizarClinica(Clinica obj) throws Exception {

		ClinicaDao newDao = (ClinicaDao) dao;
		Clinica aux = (Clinica) newDao.encontrarPorCnpj(obj.getCnpj());

		if (obj.equals(aux)) {
			newDao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar clinica.");
		}
	}

	public Clinica encontrarClinicaPorId(Long id) throws Exception {
		if (id != null) {
			return dao.encontrar(Clinica.class, id);
		} else {
			throw new ClinicaMedicaException("Erro ao encontrar clinica.");
		}
	}
	public List<Clinica> encontrarTodos() throws Exception {
		ClinicaDao newDao = (ClinicaDao) dao;
		return newDao.encontrarTodos();
		
	}
	
	public List<Funcionario> encontrarTodosFuncionarios(Clinica obj){
		FuncionarioDao newDao = new FuncionarioDao();
		return newDao.encontrarFuncionariosClinica(obj.getId());
	}
	
	public List<Medico> encontrarMedicoPorClinica(Clinica clinica) throws Exception {
		FuncionarioDao newDao = new FuncionarioDao();
		if (clinica != null) {

			return newDao.encontrarMedicosClinica(clinica.getId());
		} else {
			throw new ClinicaMedicaException("Erro ao encontrar medico.");
		}
	}
}
