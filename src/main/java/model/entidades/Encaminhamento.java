package model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENCAMINHAMENTO")
public class Encaminhamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="encaminhamento_id", nullable=false)
	private Long id;
	
	@Column(name="encaminhamento_descricao", nullable=false, length=128)
	private String descricao;
	
	@OneToOne(mappedBy="encaminhamento_id_encaminhamento")
	private Prontuario protuario;
	
	public Encaminhamento(String descricao) {
		this.descricao = descricao;
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
