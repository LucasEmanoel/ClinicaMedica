package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Clinica;
import model.util.JPAManager;

public class ClinicaDao extends DaoImpl<Clinica> implements ClinicaDaoInterface {

	public Clinica encontrarPorCnpj(String cnpj) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Clinica AS C WHERE C.cnpj = :cnpj";

		TypedQuery<Clinica> query = manager.createQuery(consulta, Clinica.class);
		query.setParameter("cnpj", cnpj);
		try {

			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}
	public Clinica getUsuario(String email, String senha) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Clinica AS C WHERE C.email = :email AND C.senha = :senha";

		TypedQuery<Clinica> query = manager.createQuery(consulta, Clinica.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);

		try {

			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}
	public List<Clinica> encontrarTodos() {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT C FROM Clinica AS C";

		TypedQuery<Clinica> query = manager.createQuery(consulta, Clinica.class);
		try {

			return query.getResultList();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

}
