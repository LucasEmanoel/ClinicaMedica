package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Funcionario;
import model.entidades.Medico;
import model.util.JPAManager;

public class FuncionarioDao extends DaoImpl<Funcionario> implements FuncionarioDaoInterface {
	
	
	public List<Funcionario> encontrarFuncionariosClinica(Long id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT F FROM Funcionario AS F WHERE F.clinica.id = :id";
		
		TypedQuery<Funcionario> query = manager.createQuery(consulta, Funcionario.class);
		query.setParameter("id", id);

		try {

			return query.getResultList();

		} catch (Exception e) {
			return null;
		} finally {

			manager.close();
		}
	}
	public List<Medico> encontrarMedicosClinica(Long id) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT M FROM Medico AS M WHERE M.clinica.id = :id AND M.crm IS NOT NULL";
		
		TypedQuery<Medico> query = manager.createQuery(consulta, Medico.class);
		query.setParameter("id", id);

		try {

			return query.getResultList();

		} catch (Exception e) {
			return null;
		} finally {

			manager.close();
		}
	}
}
