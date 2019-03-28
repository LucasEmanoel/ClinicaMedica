package model.dao;

import javax.persistence.EntityManager;

import model.entidades.Medico;
import model.util.JPAManager;

public class MedicoDao extends DaoImpl<Medico> implements MedicoDaoInterface{

	@Override
	public void salvar(Medico obj) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			manager.getTransaction().begin();		
			manager.persist(obj);
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
		}finally {
			manager.close();
		}
	}

	@Override
	public void atualizar(Medico obj) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try  {
			manager.getTransaction().begin();		
			manager.merge(obj);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public void deletar(Medico obj) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try  {
			manager.getTransaction().begin();		
			manager.remove(obj);
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
	}

	@Override
	public Medico find(Long id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

}
