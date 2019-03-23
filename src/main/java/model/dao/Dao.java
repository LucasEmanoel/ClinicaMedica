package model.dao;

public interface Dao<T> {

	public void salvar(T obj);
	public void atualizar(T obj);
	public void deletar(T obj);
	public T find(Long id);
}
