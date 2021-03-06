package model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Especialidade")
@Table(name = "especialidade")
public class Especialidade implements Serializable {

	private static final long serialVersionUID = 8851939078743070463L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "especialidade_id")
	private Long id;

	@Column(name = "especialidade_especializacao", length = 128, nullable = false)
	private String especializacao;

	@Column(name = "especialidade_rqe", nullable = false, unique = true)
	private Long rqe;

	@ManyToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "especialidades", targetEntity = Medico.class)
	private List<Medico> medicos;

	public Especialidade() {
		this.medicos=new ArrayList<Medico>();
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

	public List<Medico> getMedico() {
		return medicos;
	}

	public void setMedico(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rqe == null) ? 0 : rqe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especialidade other = (Especialidade) obj;
		if (rqe == null) {
			if (other.rqe != null)
				return false;
		} else if (!rqe.equals(other.rqe))
			return false;
		return true;
	}

}