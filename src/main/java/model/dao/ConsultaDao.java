package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import model.entidades.Consulta;
import model.entidades.Medico;
import model.entidades.Pagamento;
import model.util.JPAManager;

public class ConsultaDao extends DaoImpl<Consulta> implements ConsultaDaoInterface {

	public boolean pagar(Pagamento pag) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verificarConsulta(Medico med) {
		return true;
	}
	public List<Consulta> findConsultaPorCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Consulta> findConsultaPorData(Date data) {
		// TODO Auto-generated method stub
		return null;
	}
 
}
