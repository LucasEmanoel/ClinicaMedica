package model.dao;

import model.entidades.Secretaria;

public interface SecretariaDaoInterface {
	public Secretaria encontrarPorCpf(String cpf);
}
