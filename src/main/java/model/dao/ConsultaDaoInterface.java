package model.dao;

import java.util.Date;
import java.util.List;

import model.entidades.Consulta;
import model.entidades.Pagamento;

public interface ConsultaDaoInterface {
	public boolean pagar(Pagamento pag);
	public List<Consulta> findConsultaPorCpf(String cpf);
	public List<Consulta> findConsultaPorData(Date data);
	
}
