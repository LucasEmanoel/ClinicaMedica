package model;

import java.util.List;

import model.dao.ClinicaDao;
import model.dao.Dao;
import model.entidades.Clinica;
import model.exceptions.ClinicaMedicaException;

public class ClinicaModel {
	Dao<Clinica> dao = new ClinicaDao();

	public boolean registrarClinica(Clinica obj) throws Exception {

		ClinicaDao newDao = (ClinicaDao) dao;
		Clinica aux = (Clinica) newDao.encontrarPorCnpj(obj.getCnpj());

		if (obj.getCnpj() != null && obj.getEmail() != null && obj.getSenha() != null && obj.getEndereco() != null
				&& !(obj.equals(aux))) {
			newDao.salvar(obj);
			return true;
		} else {
			throw new ClinicaMedicaException("Erro ao cadastrar clinica.");
		}
	}

	public boolean removerClinica(Clinica obj) throws Exception {

		ClinicaDao newDao = (ClinicaDao) dao;
		Clinica aux = (Clinica) newDao.encontrarPorCnpj(obj.getCnpj());

		if (obj.equals(aux)) {
			newDao.deletar(obj);
			return true;
		} else {
			throw new ClinicaMedicaException("Erro ao remover clinica.");
		}
	}

	public boolean atualizarClinica(Clinica obj) throws Exception {

		ClinicaDao newDao = (ClinicaDao) dao;
		Clinica aux = (Clinica) newDao.encontrarPorCnpj(obj.getCnpj());

		if (obj.equals(aux)) {
			newDao.atualizar(obj);
			return true;
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
}
