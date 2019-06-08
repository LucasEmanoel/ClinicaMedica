package model.entidades;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Cliente")
@DiscriminatorValue(value = "CLIENTE")
public class Cliente extends PessoaFisica implements Serializable {

	private static final long serialVersionUID = -9113760811424501108L;

	public Cliente() {
		this.setEndereco(new Endereco());
		this.setPerfil(new Perfil());
	}
}