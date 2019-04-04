package model;

import java.util.Date;
import java.util.List;

import model.dao.ConsultaDao;
import model.dao.Dao;
import model.entidades.Consulta;
import model.entidades.Medico;

public class ConsultaModel {
	Dao<Consulta> dao = new ConsultaDao();

	public void registrarConsulta(Consulta obj) throws Exception {

		Consulta aux = (Consulta) dao.encontrar(obj.getId());
		
		if (obj != aux) {
			dao.salvar(obj);
		} else {
			throw new Exception("Erro ao realizar consulta.");
		}
	}

	public void removerConsulta(Consulta obj) throws Exception {

		Consulta aux = (Consulta) dao.encontrar(obj.getId());

		if (obj == aux) {
			dao.deletar(obj);
		} else {
			throw new Exception("Erro ao deletar consulta.");
		}
	}

	public void atualizarConsulta(Consulta obj) throws Exception {

		Consulta aux = (Consulta) dao.encontrar(obj.getId());

		if (obj == aux) {
			dao.atualizar(obj);
		} else {
			throw new Exception("Erro ao atualizar consulta.");
		}
	}

	public void encontrarConsultaPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(id);
		} else {
			throw new Exception("Erro ao encontrar consulta.");
		}
	}

	public List<Consulta> findConsultaPorIdCliente(Integer id) throws Exception {
		ConsultaDao newDao = (ConsultaDao) dao;
		if (id != null) {
			return newDao.findConsultaPorIdCliente(id);
		} else {
			throw new Exception("Erro!!");
		}
	}

	public List<Consulta> findConsultaPorData(Date data) throws Exception {
		ConsultaDao newDao = (ConsultaDao) dao;
		if (data != null) {
			return newDao.findConsultaPorData(data);
		} else {
			throw new Exception("Erro!!");
		}
	}

	public boolean verificarDisponibilidade(Medico med, Date data) throws Exception {
		ConsultaDao newDao = (ConsultaDao) dao;
		if (med != null && data != null) {
			return newDao.verificarConsulta(med, data);
		} else {
			throw new Exception("Erro!!");
		}

	}
}
