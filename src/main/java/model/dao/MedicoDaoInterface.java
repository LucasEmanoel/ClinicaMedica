package model.dao;

import model.entidades.Medico;

public interface MedicoDaoInterface {
	public Medico encontrarPorCpf(String cpf);
}
