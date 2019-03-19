package model.entidades;

public class Enfermeiro extends Funcionario {
	
	private Long coren;
	private Especialidade especialidade;
	
	public Enfermeiro(Long coren, Especialidade especialidade) {
		super();
		this.coren = coren;
		this.especialidade = especialidade;
	}
	
	public Long getCoren() {
		return coren;
	}
	public void setCoren(Long coren) {
		this.coren = coren;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	
	
	
	
}
