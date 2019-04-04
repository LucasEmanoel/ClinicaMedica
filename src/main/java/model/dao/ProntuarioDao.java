package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.entidades.Consulta;
import model.entidades.Prontuario;
import model.util.JPAManager;

public class ProntuarioDao extends DaoImpl<Prontuario> implements ProntuarioDaoInterface{

	public ProntuarioDao() {
		super(Prontuario.class);
	}

	public List<Prontuario> findProntuarioPorIdCliente(Long id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Prontuario AS P WHERE P.cliente_id = :id");
			query.setParameter("id", id);
			return query.getResultList();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}	
	
	public List<Prontuario> findProntuarioPorData(Date data) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Prontuario AS P WHERE P.prontuario_data = :data");
			query.setParameter("data", data);
			return query.getResultList();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}


}
