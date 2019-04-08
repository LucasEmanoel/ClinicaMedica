package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.entidades.Prontuario;
import model.util.JPAManager;

public class ProntuarioDao extends DaoImpl<Prontuario> implements ProntuarioDaoInterface{

	public ProntuarioDao() {
		super(Prontuario.class);
	}

	public List<Prontuario> findProntuarioPorIdCliente(Long id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Prontuario AS P WHERE P.cliente_id = :id")
			.setParameter("id", id);
			
			List<Prontuario> resultList = (List<Prontuario>) query.getResultList();
			return resultList;
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
		
	}	
	
	public List<Prontuario> findProntuarioPorData(Date data) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Prontuario AS P WHERE P.prontuario_data = :data")
			.setParameter("data", data);
			List<Prontuario> resultList = (List<Prontuario>) query.getResultList();
			return resultList;
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	
	}


}
