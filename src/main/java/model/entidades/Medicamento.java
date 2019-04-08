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

@Entity(name = "Medicamento")
@Table(name = "medicamento")
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medicamento_id", nullable = false)
	private Long id;

	@Column(name = "medicamento_descricao", nullable = false)
	private String descricao;

	@Column(name = "medicamento_quantidade", nullable = false)
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "prontuario_id", nullable = false)
	private Prontuario prontuario;

	public Medicamento(String descricao, Integer quantidade) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
	}
	public Medicamento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

}
