package model.dao;


public interface Dao<T> {
	
	public T salvar(T obj);
	public T atualizar(T obj);
	public boolean deletar(T obj);
	public T encontrar(Class<T> c, Long id);

}