package model.dao;

import java.util.Date;
import java.util.List;

import model.entidades.Consulta;

public interface ConsultaDaoInterface {
	
	public List<Consulta> findConsultaPorCpfCliente(String cpf);
	public List<Consulta> findConsultaPorData(Date data);
	
}
