package model.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "PessoaJuridica")
@DiscriminatorValue(value = "PJ")
public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = 1L;

	
	@Column(name = "cnpj", unique = true, length = 32)
	private String cnpj;

	
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
