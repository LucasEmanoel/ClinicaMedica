package model.entidades;

public class Medico extends Funcionario {
	private Long crm;
	private Especialidade especialidade;
	
	public Medico(Long crm, Especialidade especialidade) {
		super();
		this.crm = crm;
		this.especialidade = especialidade;
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	
	
	
	
	
}
