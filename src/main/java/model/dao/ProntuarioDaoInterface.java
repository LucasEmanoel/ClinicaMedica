package model.dao;

import java.util.Date;
import java.util.List;

import model.entidades.Prontuario;

public interface ProntuarioDaoInterface {
	
	public List<Prontuario> findProntuarioPorIdCliente(Long id);
	public List<Prontuario> findProntuarioPorData(Date data);
}
