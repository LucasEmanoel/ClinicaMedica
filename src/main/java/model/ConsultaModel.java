package model;


import java.util.Calendar;
import java.util.List;

import model.dao.ConsultaDao;
import model.dao.Dao;
import model.entidades.Consulta;
import model.entidades.Medico;
import model.exceptions.ClinicaMedicaException;

public class ConsultaModel {
	Dao<Consulta> dao = new ConsultaDao();

	public void registrarConsulta(Consulta obj) throws Exception {
		
		ConsultaDao newDao = (ConsultaDao) dao;
		Consulta aux = (Consulta) newDao.findConsultaPorCpfCliente(obj.getCliente().getCpf());
		boolean consultaDisponivel = newDao.verificarConsulta(obj.getMedico(), obj.getData());

		if (obj.getData() != null && obj.getCliente() != null && obj.getMedico() != null
				&& obj.getPagamento() != null && obj.getDescricao() != null && consultaDisponivel == true
				&& !(obj.equals(aux))) {
			dao.salvar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao realizar consulta.");
		}
	}

	public void removerConsulta(Consulta obj) throws Exception {

		ConsultaDao newDao = (ConsultaDao) dao;
		Consulta aux = (Consulta) newDao.findConsultaPorCpfCliente(obj.getCliente().getCpf());

		if (obj.equals(aux)) {
			dao.deletar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao deletar consulta.");
		}
	}

	public void atualizarConsulta(Consulta obj) throws Exception {

		ConsultaDao newDao = (ConsultaDao) dao;
		Consulta aux = (Consulta) newDao.findConsultaPorCpfCliente(obj.getCliente().getCpf());


		if (obj.equals(aux)) {
			dao.atualizar(obj);
		} else {
			throw new ClinicaMedicaException("Erro ao atualizar consulta.");
		}
	}

	public void encontrarConsultaPorId(Long id) throws Exception {
		if (id != null) {
			dao.encontrar(Consulta.class, id);
		} else {
			throw new ClinicaMedicaException("Erro ao encontrar consulta.");
		}
	}

	public List<Consulta> findConsultaPorCpfCliente(String cpf) throws Exception {
		ConsultaDao newDao = (ConsultaDao) dao;
		if (cpf != null) {
			return newDao.findConsultaPorCpfCliente(cpf);
		} else {
			throw new ClinicaMedicaException("Erro ao encontrar consultas por cliente!!");
		}
	}

	public List<Consulta> findConsultaPorData(String string) throws Exception {
		ConsultaDao newDao = (ConsultaDao) dao;
		if (string != null) {
			return newDao.findConsultaPorData(string);
		} else {
			throw new ClinicaMedicaException("Erro listar consultas por data!!");
		}
	}

	public boolean verificarDisponibilidade(Medico med, Calendar data) throws Exception {
		ConsultaDao newDao = (ConsultaDao) dao;
		if (med != null && data != null) {
			return newDao.verificarConsulta(med, data);
		} else {
			throw new ClinicaMedicaException("Erro ao verificar disponibilidade!!");
		}

	}
}
