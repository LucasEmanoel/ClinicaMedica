package model;

import model.dao.AmbulatorioDao;
import model.dao.Dao;
import model.entidades.Ambulatorio;
import model.exceptions.ClinicaMedicaException;

public class AmbulatorioModel {

	Dao<Ambulatorio> dao = new AmbulatorioDao();

	public void registrarAmbulatorio(Ambulatorio obj) throws Exception {

		AmbulatorioDao newDao = (AmbulatorioDao) dao;
		Ambulatorio aux = (Ambulatorio) newDao.encontrarByNumero(obj.getNumero());

		if (obj.getNumero() != null && obj.getAndar() != null && !(obj.equals(aux))) {
			newDao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao registrar ambulatorio.");
		}
	}

	public void removerAmbulatorio(Ambulatorio obj) throws Exception {

		AmbulatorioDao newDao = (AmbulatorioDao) dao;
		Ambulatorio aux = (Ambulatorio) newDao.encontrarByNumero(obj.getNumero());

		if (obj.equals(aux)) {
			newDao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao deletar ambulatorio.");
		}
	}

	public void atualizarAmbulatorio(Ambulatorio obj) throws Exception {

		AmbulatorioDao newDao = (AmbulatorioDao) dao;
		Ambulatorio aux = (Ambulatorio) newDao.encontrarByNumero(obj.getNumero());

		if (obj.equals(aux)) {
			newDao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar ambulatorio.");
		}
	}

	public Ambulatorio encontrarAmbulatorioPorId(Long id) throws Exception {
		if (id != null) {
			return dao.encontrar(Ambulatorio.class, id);
		} else {
			throw new ClinicaMedicaException("Erro ao encontrar ambulatorio.");
		}
	}
}
