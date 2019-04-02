  package model;

import java.util.Date;
import java.util.List;

import model.dao.ConsultaDao;
import model.dao.Dao;
import model.entidades.Consulta;
import model.entidades.Pagamento;

public class ConsultaModel {
	Dao<Consulta> dao = new ConsultaDao();  
	
	public void registrarConsulta(Consulta obj) throws Exception{
		if (obj != null) {
			dao.salvar(obj);
		}else{
			throw new Exception("Erro!!");
		}
	}
	
	public void removerConsulta(Consulta obj) throws Exception{
		if (obj != null) {
			dao.deletar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	
	public void atualizarConsulta(Consulta obj) throws Exception{
		if (obj != null) {
			dao.atualizar(obj);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public void pagarConsulta(Pagamento pag) throws Exception{
		ConsultaDao newDao = (ConsultaDao) dao;
		if (pag != null) {
			newDao.pagar(pag);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public Consulta findConsulta(Long id) throws Exception{
		if(id != null) {
			return dao.find(id);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public List<Consulta> findConsultaPorCpf(String cpf) throws Exception{
		ConsultaDao newDao = (ConsultaDao) dao;
		if(cpf != null) {
			return newDao.findConsultaPorCpf(cpf);
		}else {
			throw new Exception("Erro!!");
		}
	}
	public List<Consulta> findConsultaPorData(Date data) throws Exception {
		ConsultaDao newDao = (ConsultaDao) dao;
		if(data != null) {
			return newDao.findConsultaPorData(data);
		}else {
			throw new Exception("Erro!!");
		}
	}
}
