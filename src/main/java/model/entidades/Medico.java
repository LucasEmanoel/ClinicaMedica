package model.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "Medico")
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Funcionario implements Serializable {

	private static final long serialVersionUID = 7613514159588447175L;

	@Column(name = "medico_crm", unique = true)
	private Long crm;

	@Column(name = "medico_meta_diaria")
	private Integer meta;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Especialidade.class)
	@JoinTable(name = "medico_especialidade", joinColumns = @JoinColumn(name = "pessoa_id", referencedColumnName = "pessoa_id"),
				inverseJoinColumns = @JoinColumn(name = "especialidade_id", referencedColumnName = "especialidade_id"))
	private List<Especialidade> especialidades;

	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;

	public Medico() {
		this.consultas = null;
		this.especialidades = null;
		this.setEndereco(new Endereco());
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}

	public Integer getMeta() {
		return meta;
	}

	public void setMeta(Integer meta) {
		this.meta = meta;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((crm == null) ? 0 : crm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (crm == null) {
			if (other.crm != null)
				return false;
		} else if (!crm.equals(other.crm))
			return false;
		return true;
	}

}