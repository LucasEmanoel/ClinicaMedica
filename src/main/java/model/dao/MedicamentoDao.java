package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Medicamento;
import model.util.JPAManager;

public class MedicamentoDao extends DaoImpl<Medicamento> implements MedicamentoDaoInterface {

	@Override
	public Medicamento findMedicamentoByCod(Long cod) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT M FROM Medicamento AS M WHERE M.cod = :cod";

		TypedQuery<Medicamento> query = manager.createQuery(consulta, Medicamento.class);
		query.setParameter("cod", cod);

		try {
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

}
