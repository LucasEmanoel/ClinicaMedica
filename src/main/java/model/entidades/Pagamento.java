package model.entidades;

public class Pagamento {
	private Long id;
	private Double valor;
	
	public Pagamento(Double valor) {
		super();
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
