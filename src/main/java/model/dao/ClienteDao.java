package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Cliente;
import model.util.JPAManager;

public class ClienteDao extends DaoImpl<Cliente> implements ClienteDaoInterface{

	@Override
	public Cliente encontrarPorCpf(String cpf) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Cliente AS C WHERE C.cpf = :cpf";

		TypedQuery<Cliente> query = manager.createQuery(consulta, Cliente.class);
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
