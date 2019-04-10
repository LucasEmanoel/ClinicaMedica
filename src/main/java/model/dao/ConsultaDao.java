package model.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Consulta;
import model.entidades.Medico;
import model.util.JPAManager;

public class ConsultaDao extends DaoImpl<Consulta> implements ConsultaDaoInterface {

	public List<Consulta> findConsultaPorIdCliente(Integer id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		String consulta = "SELECT C FROM Consulta AS C WHERE C.cliente_id = :id";
		
		TypedQuery<Consulta> query = 
				manager.createQuery(consulta, Consulta.class);
		query.setParameter("id", id);
		
		try {
			
			return query.getResultList();
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
		
	}

	public List<Consulta> findConsultaPorData(Date data) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		String consulta = "SELECT * FROM Consulta AS C WHERE C.consulta_data = :data";
		
		TypedQuery<Consulta> query = 
				manager.createQuery(consulta, Consulta.class);
		query.setParameter("data", data);
		
		try {
			
			return query.getResultList();
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

	public boolean verificarConsulta(Medico m, Date d) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		String consulta = "SELECT * FROM Consulta AS C WHERE C.consulta_data = :data && C.medico_id = :id";
		
		TypedQuery<Consulta> query = 
				manager.createQuery(consulta, Consulta.class);
		query.setParameter("data", d);
		query.setParameter("id", m.getId());
		
		try {
			
			if(query.getResultList().size() < m.getMeta()) {
				return true;
			}
			
		} catch (Exception e) {
		} finally {
			manager.close();
		}
		return false;
		
	
	}

}