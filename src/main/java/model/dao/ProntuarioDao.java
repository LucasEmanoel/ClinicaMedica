package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Prontuario;
import model.util.JPAManager;

public class ProntuarioDao extends DaoImpl<Prontuario> implements ProntuarioDaoInterface{


	public List<Prontuario> findProntuarioPorIdCliente(Long id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		String consulta = "SELECT P FROM Prontuario AS P WHERE P.cliente_id = :id";
		
		TypedQuery<Prontuario> query = 
				manager.createQuery(consulta, Prontuario.class);
		query.setParameter("id", id);
		try {
			
			return query.getResultList();
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
		
	}	
	
	public List<Prontuario> findProntuarioPorData(Date data) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
	
		String consulta = "SELECT * FROM Prontuario AS P WHERE P.prontuario_data = :data";
		
		TypedQuery<Prontuario> query = 
				manager.createQuery(consulta, Prontuario.class);
		query.setParameter("data", data);
		
		try {
			
			return query.getResultList();
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	
	}


}
