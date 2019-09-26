package model.dao;

import model.entidades.Cliente;

public interface ClienteDaoInterface {
	public Cliente encontrarPorCpf(String cpf);
}
