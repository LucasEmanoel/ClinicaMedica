package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Medico;
import model.util.JPAManager;

public class MedicoDao extends DaoImpl<Medico> implements MedicoDaoInterface {

	@Override
	public Medico encontrarPorCpf(String cpf) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Medico AS C WHERE C.cpf = :cpf";

		TypedQuery<Medico> query = manager.createQuery(consulta, Medico.class);
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
