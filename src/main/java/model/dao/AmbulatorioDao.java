package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Ambulatorio;
import model.util.JPAManager;

public class AmbulatorioDao extends DaoImpl<Ambulatorio> implements AmbulatorioDaoInterface {

	public Ambulatorio encontrarByNumero(Integer n) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT A FROM Ambulatorio AS A WHERE A.numero = :numero";

		TypedQuery<Ambulatorio> query = manager.createQuery(consulta, Ambulatorio.class);
		query.setParameter("numero", n);

		try {
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}

	}

}
