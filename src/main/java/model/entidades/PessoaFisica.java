package model.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "PessoaFisica")
@DiscriminatorValue(value = "PF")
public class PessoaFisica extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "cpf", unique = true, length = 32)
	private String cpf;
	
	@Column(name = "rg", unique = true, length = 32)
	private String rg;
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

}