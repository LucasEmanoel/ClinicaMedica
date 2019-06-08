package model.entidades;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Clinica")
@DiscriminatorValue(value = "CLINICA")
public class Clinica extends PessoaJuridica implements Serializable {

	private static final long serialVersionUID = -6682936365279176191L;
	
	public Clinica() {
		this.setEndereco(new Endereco());
		this.setPerfil(new Perfil());
		
	}

}