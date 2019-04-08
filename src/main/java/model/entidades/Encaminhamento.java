package model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Encaminhamento")
@Table(name = "encaminhamento")
public class Encaminhamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "encaminhamento_id", nullable = false)
	private Long id;

	@Column(name = "encaminhamento_descricao", nullable = false, length = 128)
	private String descricao;

	public Encaminhamento(String descricao) {
		this.descricao = descricao;
	}
	public Encaminhamento() {
		
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
}