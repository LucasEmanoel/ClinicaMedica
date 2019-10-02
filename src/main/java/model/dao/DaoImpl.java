package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Ambulatorio;
import model.util.JPAManager;

public class DaoImpl<T> implements Dao<T> {

	public void salvar(T obj) {
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

	public void atualizar(T obj) {
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
	
	public void deletar(T obj) {

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

	public T encontrar(Class<T> clazz, Long id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try  {
		
			return manager.find(clazz, id);
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	
	}
}
