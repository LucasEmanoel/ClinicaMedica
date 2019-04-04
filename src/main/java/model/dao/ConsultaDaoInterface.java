package model.dao;

import java.util.Date;
import java.util.List;

import model.entidades.Consulta;

public interface ConsultaDaoInterface {
	
	public List<Consulta> findConsultaPorIdCliente(Integer id);
	public List<Consulta> findConsultaPorData(Date data);
	
}
