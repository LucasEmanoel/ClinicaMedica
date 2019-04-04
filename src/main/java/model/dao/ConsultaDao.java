package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.entidades.Consulta;
import model.entidades.Medico;
import model.util.JPAManager;

public class ConsultaDao extends DaoImpl<Consulta> implements ConsultaDaoInterface {

	public ConsultaDao() {
		super(Consulta.class);
	}

	public List<Consulta> findConsultaPorIdCliente(Integer id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Consulta AS C WHERE C.cliente_id = :id");
			query.setParameter( "id", id );
			return query.getResultList();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

	public List<Consulta> findConsultaPorData(Date data) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Consulta AS C WHERE C.consulta_data = :data");
			query.setParameter( "data", data );
			return query.getResultList();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	}

	public boolean verificarConsulta(Medico m, Date d) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Consulta AS C WHERE C.consulta_data = :data && C.medico_id = :id ");
			query.setParameter("data", d);
			query.setParameter("medico_id", m.getId());
			
			if(query.getResultList().size() < m.getMeta()) {
				return true;
			}
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		
		return false;
	}

}