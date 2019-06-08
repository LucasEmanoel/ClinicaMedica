package model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "Funcionario")
@DiscriminatorValue(value = "FUNCIONARIO")
public class Funcionario extends PessoaFisica implements Serializable {

	private static final long serialVersionUID = -731396741330887156L;

	
	@Column(name = "funcionario_salario")
	private Double salario;
	
	@ManyToOne
	private Clinica clinica;

	
	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
	
}