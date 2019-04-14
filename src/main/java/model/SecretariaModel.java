package model;

import model.dao.Dao;
import model.dao.PessoaDao;
import model.entidades.Pessoa;
import model.entidades.Secretaria;
import model.exceptions.ClinicaMedicaException;

public class SecretariaModel {
	Dao<Pessoa> dao = new PessoaDao();

	public void registrarSecretaria(Secretaria obj) throws Exception {

		PessoaDao newDao = (PessoaDao) dao;
		Secretaria aux = (Secretaria) newDao.encontrarPorCpf(obj.getCpf());

		if (obj.getNome() != null && obj.getCpf() != null && obj.getRg() != null && obj.getEmail() != null
				&& obj.getSenha() != null && obj.getSalario() != null && obj.getIdade() > 0
				&& obj.getQualificacao() != null && obj.getClinica() != null && !(obj.equals(aux))) {
			dao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao registrar secretaria.");
		}
	}

	public void removerSecretaria(Secretaria obj) throws Exception {

		PessoaDao newDao = (PessoaDao) dao;
		Secretaria aux = (Secretaria) newDao.encontrarPorCpf(obj.getCpf());

		if (obj.equals(aux)) {
			dao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao deletar secretaria.");
		}
	}

	public void atualizarSecretaria(Secretaria obj) throws Exception {

		PessoaDao newDao = (PessoaDao) dao;
		Secretaria aux = (Secretaria) newDao.encontrarPorCpf(obj.getCpf());

		if (obj.equals(aux)) {
			dao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar secretaria.");
		}
	}

	public Secretaria encontrarSecretariaPorId(Long id) throws Exception {
		if (id != null) {
			return (Secretaria) dao.encontrar(Pessoa.class, id);
		} else {
			throw new ClinicaMedicaException("Erro encontrar secretaria.");
		}
	}
}
