package model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Especialidade")
@Table(name = "especialidade")
public class Especialidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "especialidade_id", nullable = false)
	private Long id;

	@Column(name = "especialidade_especializacao", length = 128, nullable = false)
	private String especializacao;

	@Column(name = "especialidade_rqe", nullable = false)
	private Long rqe;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medico_id")
	private Medico medico;

	public Especialidade(String especializacao, Long rqe) {
		this.especializacao = especializacao;
		this.rqe = rqe;
	}
	public Especialidade() {
		
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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}