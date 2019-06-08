package model.dao;

import java.util.List;

import model.entidades.Funcionario;
import model.entidades.Medico;

public interface FuncionarioDaoInterface {
	public List<Funcionario> encontrarFuncionariosClinica(Long id);
	public List<Medico> encontrarMedicosClinica(Long id);
}	
