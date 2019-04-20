package model.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.entidades.Pessoa;
import model.util.JPAManager;

public class PessoaDao extends DaoImpl<Pessoa> implements PessoaDaoInterface {

	public Pessoa encontrarPorCpf(String cpf) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT P FROM Pessoa AS P WHERE P.cpf = :cpf";

		TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
		query.setParameter("cpf", cpf);

		try {

			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		} finally {

			manager.close();
		}
	}
	public Pessoa getUsuario(String email, String senha) {
		EntityManager manager = JPAManager.getInstance().getEntityManager();

		String consulta = "SELECT P FROM Pessoa AS P WHERE P. email = :email AND P.senha = :senha";

		TypedQuery<Pessoa> query = manager.createQuery(consulta, Pessoa.class);
		query.setParameter("email", email);
		query.setParameter("senha", senha);

		try {

			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		} finally {

			manager.close();
		}
	}
}