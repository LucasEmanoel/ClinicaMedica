package model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Endereco")
@Table(name = "endereco")
public class Endereco implements Serializable{

	private static final long serialVersionUID = -6760847364964303770L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "endereco_id")
	private Long id;

	@Column(name = "rua", length = 128)
	private String rua;

	@Column(name = "bairro", length = 128)
	private String bairro;

	@Column(name = "cep", length = 128)
	private String cep;

	public Endereco(String rua, String bairro, String cep) {
		super();
		this.rua = rua;
		this.bairro = bairro;
		this.cep = cep;
	}
	public Endereco() {
		
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