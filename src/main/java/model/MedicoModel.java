package model;

import model.dao.Dao;
import model.dao.PessoaDao;
import model.entidades.Medico;
import model.entidades.Pessoa;
import model.exceptions.ClinicaMedicaException;

public class MedicoModel {
	Dao<Pessoa> dao = new PessoaDao();

	public void registrarMedico(Medico obj) throws Exception {

		PessoaDao newDao = (PessoaDao) dao;
		Medico aux = (Medico) newDao.encontrarPorCpf(obj.getCpf());

		if (obj.getNome() != null && obj.getCpf() != null && obj.getRg() != null && obj.getIdade() > 0
				&& obj.getEmail() != null && obj.getSenha() != null && obj.getSalario() != null && obj.getCrm() != null
				&& !(obj.equals(aux))) {
			newDao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao registrar medico.");
		}
	}

	public void removerMedico(Medico obj) throws Exception {

		PessoaDao newDao = (PessoaDao) dao;
		Medico aux = (Medico) newDao.encontrarPorCpf(obj.getCpf());

		if (obj.equals(aux)) {
			dao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao remover medico.");
		}
	}

	public void atualizarMedico(Medico obj) throws Exception {

		PessoaDao newDao = (PessoaDao) dao;
		Medico aux = (Medico) newDao.encontrarPorCpf(obj.getCpf());

		if (obj.equals(aux)) {
			dao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar medico.");
		}
	}

	public Medico encontrarMedicoPorId(Long id) throws Exception {
		if (id != null) {

			return (Medico) dao.encontrar(Pessoa.class, id);
		} else {
			throw new ClinicaMedicaException("Erro ao encontrar medico.");
		}
	}
}
