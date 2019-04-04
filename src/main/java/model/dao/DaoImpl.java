package model.dao;

import javax.persistence.EntityManager;

import model.util.JPAManager;

public class DaoImpl<T> implements Dao<T> {

	private Class<T> persisted;
	
	public DaoImpl(Class<T> persistedClass) {
	    this.persisted = persistedClass;
	}
	
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

	public T encontrar(Long id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try  {
			
			return manager.find(persisted, id);
			
		} catch (Exception e) {
			manager.getTransaction().rollback();
		} finally {
			manager.close();
		}
		return null;
	
	}
}
