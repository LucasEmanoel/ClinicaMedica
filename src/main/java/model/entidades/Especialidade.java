package model.entidades;

public class Especialidade {
	private Long id;
	private String especializacao;
	private Long rqe;
	
	public Especialidade(String especializacao, Long rqe) {
		this.especializacao = especializacao;
		this.rqe = rqe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	public Long getRqe() {
		return rqe;
	}

	public void setRqe(Long rqe) {
		this.rqe = rqe;
	}
	
	
	
	
}
