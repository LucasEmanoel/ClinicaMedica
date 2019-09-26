package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Secretaria;
import model.util.JPAManager;

public class SecretariaDao extends DaoImpl<Secretaria> implements SecretariaDaoInterface {

	@Override
	public Secretaria encontrarPorCpf(String cpf) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Secretaria AS C WHERE C.cpf = :cpf";

		TypedQuery<Secretaria> query = manager.createQuery(consulta, Secretaria.class);
		query.setParameter("cpf", cpf);

		try {

			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

}
