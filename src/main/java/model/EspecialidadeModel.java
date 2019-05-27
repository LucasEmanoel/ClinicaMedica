package model;

import model.dao.Dao;
import model.dao.EspecialidadeDao;
import model.entidades.Especialidade;
import model.exceptions.ClinicaMedicaException;

public class EspecialidadeModel {
	Dao<Especialidade> dao = new EspecialidadeDao();

	public void registrarEspecialidade(Especialidade obj) throws Exception {

		EspecialidadeDao newDao = (EspecialidadeDao) dao;
		Especialidade aux = newDao.encontarPorRqe(obj.getRqe());

		if (obj.getEspecializacao() != null && obj.getRqe() != null && obj.getMedico() != null && !(obj.equals(aux))) {
			dao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao registrar especialidade.");
		}
	}

	public void removerEspecialidade(Especialidade obj) throws Exception {

		EspecialidadeDao newDao = (EspecialidadeDao) dao;
		Especialidade aux = newDao.encontarPorRqe(obj.getRqe());

		if (obj.equals(aux)) {
			dao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao deletar especialidade.");
		}
	}

	public void atualizarEspecialidade(Especialidade obj) throws Exception {

		EspecialidadeDao newDao = (EspecialidadeDao) dao;
		Especialidade aux = newDao.encontarPorRqe(obj.getRqe());

		if (obj.equals(aux)) {
			dao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar especialidade.");
		}
	}

	public void encontrarEspecialidadePorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Especialidade.class, id);
		} else {
			throw new ClinicaMedicaException("Erro ao encotrar especialidade.");
		}
	}
}
