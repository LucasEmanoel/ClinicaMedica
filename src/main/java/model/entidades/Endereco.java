package model.entidades;

public class Endereco {
	private Long id;
	private String rua;
	private String bairro;
	private String cep;
	
	
	public Endereco(String rua, String bairro, String cep) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
}
