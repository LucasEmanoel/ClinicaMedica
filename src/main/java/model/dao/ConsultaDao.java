package model.dao;

import javax.persistence.EntityManager;

import model.entidades.Consulta;
import model.util.JPAManager;

public class ConsultaDao extends DaoImpl<Consulta> implements ConsultaDaoInterface {

	@Override
	public void salvar(Consulta obj) {
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
	public void atualizar(Consulta obj) {
		// TODO Auto-generated method stub
		super.atualizar(obj);
	}

	@Override
	public void deletar(Consulta obj) {
		// TODO Auto-generated method stub
		super.deletar(obj);
	}

	@Override
	public Consulta find(Long id) {
		// TODO Auto-generated method stub
		return super.find(id);
	}
 
}
