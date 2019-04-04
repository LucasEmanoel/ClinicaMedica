package controller;

import model.EspecialidadeModel;
import model.entidades.Especialidade;

public class teste {
	
	public static void registrarEspecialidade(Especialidade e) throws Exception {
		
		EspecialidadeModel em = new EspecialidadeModel();
		em.registrarEspecialidade(e);
		
	}
}
