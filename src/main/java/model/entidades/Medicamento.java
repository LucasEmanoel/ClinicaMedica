package model.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Medicamento")
@Table(name = "medicamento")
public class Medicamento implements Serializable {

	private static final long serialVersionUID = 353178706384886254L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicamento_id")
	private Long id;

	@Column(name = "medicamento_cod", nullable = false, unique = true)
	private Long cod;

	@Column(name = "medicamento_descricao", nullable = false)
	private String descricao;

	@Column(name = "medicamento_quantidade")
	private Integer quantidade;

	@ManyToMany(cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "medicamentos", targetEntity = Consulta.class)
	private List<Consulta> prontuarios;

	public Medicamento(Long cod, String descricao) {
		super();
		this.cod = cod;
		this.descricao = descricao;
	}

	public Medicamento() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return cod;
	}

	public void setCode(Long cod) {
		this.cod = cod;
	}

	public List<Consulta> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Consulta> prontuarios) {
		this.prontuarios = prontuarios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
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
		Medicamento other = (Medicamento) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

}
