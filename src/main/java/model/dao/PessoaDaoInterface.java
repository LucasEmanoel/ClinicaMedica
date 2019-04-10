package model.dao;

import model.entidades.Pessoa;

public interface PessoaDaoInterface {

	public Pessoa encontrarPorCpf(String cpf);

}
