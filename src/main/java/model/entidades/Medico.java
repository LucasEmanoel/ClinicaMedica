package model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name = "Medico")
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Funcionario implements Serializable {

	private static final long serialVersionUID = 7613514159588447175L;

	@Column(name = "medico_crm", unique = true)
	private Long crm;

	@Column(name = "medico_meta_diaria")
	private Integer meta;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Especialidade.class)
	@JoinTable(name = "medico_especialidade", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name = "especialidade_id", referencedColumnName = "especialidade_id"))
	private List<Especialidade> especialidades;

	public Medico() {
		this.setEndereco(new Endereco());
		this.especialidades = new ArrayList<Especialidade>();
		this.setClinica(new Clinica());
		this.setPerfil(new Perfil());
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