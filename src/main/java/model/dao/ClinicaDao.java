package model.dao;

import javax.persistence.EntityManager;

import model.entidades.Clinica;
import model.util.JPAManager;

public class ClinicaDao extends DaoImpl<Clinica> implements ClinicaDaoInterface{

	@Override
	public void salvar(Clinica obj) {
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
	public void atualizar(Clinica obj) {
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
	public void deletar(Clinica obj) {
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
	public Clinica find(Long id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}

}
