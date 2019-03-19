package model.entidades;

public class Medicamento {
	private Long id;
	private String descricao;
	private Integer quantidade;
	
	public Medicamento(String descricao, Integer quantidade) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
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
