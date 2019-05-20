package model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Secretaria")
@DiscriminatorValue(value = "SECRETARIA")
public class Secretaria extends Funcionario implements Serializable {

	private static final long serialVersionUID = -4298092151407776552L;

	@Column(name = "secretaria_qualificacao", length = 128)
	private String qualificacao;

	public Secretaria() {
		this.setEndereco(new Endereco());
	}

	public String getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(String qualificacao) {
		this.qualificacao = qualificacao;
	}
}