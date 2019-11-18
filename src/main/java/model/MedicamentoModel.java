package model;

import model.dao.Dao;
import model.dao.MedicamentoDao;
import model.entidades.Medicamento;
import model.exceptions.ClinicaMedicaException;

public class MedicamentoModel {
	Dao<Medicamento> dao = new MedicamentoDao();

	public void registrarMedicamento(Medicamento obj) throws Exception {

		MedicamentoDao newDao = (MedicamentoDao) dao;
		Medicamento aux = newDao.findMedicamentoByCod(obj.getCode());

		if (obj.getDescricao() != null && obj.getCode() != null && !(obj.equals(aux))) {
			dao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao registrar medicamento.");
		}
	}

	public void removerMedicamento(Medicamento obj) throws Exception {

		MedicamentoDao newDao = (MedicamentoDao) dao;
		Medicamento aux = newDao.findMedicamentoByCod(obj.getCode());

		if (obj.equals(aux)) {
			dao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao remover medicamento.");
		}
	}

	public void atualizarMedicamento(Medicamento obj) throws Exception {

		MedicamentoDao newDao = (MedicamentoDao) dao;
		Medicamento aux = newDao.findMedicamentoByCod(obj.getCode());

		if (obj.equals(aux)) {
			dao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar medicamento.");
		}
	}

	public void encontrarMedicamentoPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Medicamento.class, id);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar medicamento.");
		}
	}
}
