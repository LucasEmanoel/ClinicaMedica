package model.dao;

import javax.persistence.EntityManager;

import model.util.JPAManager;

public class DaoImpl<T> implements Dao<T> {

	public T salvar(T obj) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try {
			manager.getTransaction().begin();	
			manager.persist(obj);
			manager.getTransaction().commit();
			return obj;
		} catch (Exception e) {
			
			manager.getTransaction().rollback();
			return null;
		}finally {
			manager.close();
		}
	
		
	}

	public T atualizar(T obj) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try  {
			manager.getTransaction().begin();		
			manager.merge(obj);
			manager.getTransaction().commit();
			return obj;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			return null;
		} finally {
			manager.close();
		}

	}
	
	public boolean deletar(T obj) {

		EntityManager manager = JPAManager.getInstance().getEntityManager();
		
		try  {
			manager.getTransaction().begin();		
			manager.remove(manager.merge(obj));
			manager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			return false;
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
