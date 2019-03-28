package model.dao;

import javax.persistence.EntityManager;

import model.entidades.Cliente;
import model.util.JPAManager;

public class ClienteDao extends DaoImpl<Cliente> implements ClienteDaoInterface{

	@Override
	public void salvar(Cliente obj) {
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
	public void atualizar(Cliente obj) {
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
	public void deletar(Cliente obj) {
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
	public Cliente find(Long id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

	
}
