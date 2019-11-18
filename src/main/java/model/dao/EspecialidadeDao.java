package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Especialidade;
import model.util.JPAManager;

public class EspecialidadeDao extends DaoImpl<Especialidade> implements EspecialidadeDaoInterface {

	public Especialidade encontarPorRqe(Long rqe) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT E FROM Especialidade AS E WHERE E.rqe = :rqe";

		TypedQuery<Especialidade> query = manager.createQuery(consulta, Especialidade.class);
		query.setParameter("rqe", rqe);

		try {

			return query.getSingleResult();

		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

}
