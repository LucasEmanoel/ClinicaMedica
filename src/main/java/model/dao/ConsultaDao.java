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
			
			Query query = manager.createQuery("SELECT * FROM Consulta AS C WHERE C.cliente_id = :id").setParameter( "id", id );
			List<Consulta> resultList = (List<Consulta>) query.getResultList();
			return resultList;
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
		
	}

	public List<Consulta> findConsultaPorData(Date data) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Consulta AS C WHERE C.consulta_data = :data").setParameter( "data", data );
			List<Consulta> resultList = (List<Consulta>) query.getResultList();
			return resultList;
			
		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

	public boolean verificarConsulta(Medico m, Date d) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			
			Query query = manager.createQuery("SELECT * FROM Consulta AS C WHERE C.consulta_data = :data && C.medico_id = :id ")
			.setParameter("data", d)
			.setParameter("medico_id", m.getId());
			
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