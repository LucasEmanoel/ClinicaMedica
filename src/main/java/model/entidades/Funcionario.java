package model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Funcionario")
public abstract class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = -731396741330887156L;

	@Column(name = "funcionario_salario")
	private Double salario;

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
}