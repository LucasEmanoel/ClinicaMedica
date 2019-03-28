package model.dao;

import javax.persistence.EntityManager;

import model.entidades.Secretaria;
import model.util.JPAManager;

public class SecretariaDao extends DaoImpl<Secretaria> implements SecretariaDaoInterface{

	@Override
	public void salvar(Secretaria obj) {
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
	public void atualizar(Secretaria obj) {
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
	public void deletar(Secretaria obj) {
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
	public Secretaria find(Long id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

}
