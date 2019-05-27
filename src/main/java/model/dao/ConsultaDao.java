package model.dao;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Consulta;
import model.entidades.Medico;
import model.util.JPAManager;

public class ConsultaDao extends DaoImpl<Consulta> implements ConsultaDaoInterface {

	public List<Consulta> findConsultaPorCpfCliente(String cpf) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Consulta AS C WHERE C.cliente = :cpf";

		TypedQuery<Consulta> query = manager.createQuery(consulta, Consulta.class);
		query.setParameter("cpf", cpf);

		try {

			return query.getResultList();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}

	}

	public List<Consulta> findConsultaPorData(String string) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Consulta AS C WHERE C.data = :data";

		TypedQuery<Consulta> query = manager.createQuery(consulta, Consulta.class);
		query.setParameter("data", string);

		try {

			return query.getResultList();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

	public boolean verificarConsulta(Medico m, Timestamp d) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Consulta AS C WHERE C.horario = :horario AND C.medico.cpf = :cpf";

		TypedQuery<Consulta> query = manager.createQuery(consulta, Consulta.class);
		query.setParameter("horario", d);
		query.setParameter("cpf", m.getCpf());

		try {

			if (query.getResultList().size() < m.getMeta()) {
				return true;
			}

		} catch (Exception e) {
		} finally {
			manager.close();
		}
		return false;

	}

}