package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Clinica;
import model.util.JPAManager;

public class ClinicaDao extends DaoImpl<Clinica> implements ClinicaDaoInterface {

	public Clinica encontrarPorCnpj(String cnpj) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		String consulta ="SELECT C FROM Clinica AS C WHERE C.cnpj = :cnpj";
		
		TypedQuery<Clinica> query = 
				manager.createQuery(consulta, Clinica.class);
		query.setParameter("cnpj", cnpj);
		try {
			
			return query.getSingleResult();
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

}