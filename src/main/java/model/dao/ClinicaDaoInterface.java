package model.dao;

import model.entidades.Clinica;

public interface ClinicaDaoInterface {
	public Clinica encontrarPorCnpj(String cnpj);
}
