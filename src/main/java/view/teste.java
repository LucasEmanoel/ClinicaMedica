package view;


import model.entidades.Especialidade;

public class teste {

	public static void main(String[] args) throws Exception {
		
		Especialidade e = new Especialidade("Clinico Geral", 1545L);
		controller.teste.registrarEspecialidade(e);
		
	}

}
