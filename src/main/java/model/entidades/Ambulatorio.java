package model.entidades;

public class Ambulatorio {
	private Long id;
	private Integer numero;
	private Integer andar;
	
	public Ambulatorio(Integer numero, Integer andar) {
		super();
		this.numero = numero;
		this.andar = andar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}
	
	
	
}
