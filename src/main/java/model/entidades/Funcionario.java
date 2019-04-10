package model.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Funcionario")
@DiscriminatorValue(value = "FUNCIONARIO")
public abstract class Funcionario extends Pessoa implements Serializable{

	private static final long serialVersionUID = -731396741330887156L;

	@Column(name = "funcionario_email", unique = true, length = 64)
	private String email;

	@Column(name = "funcionario_senha", unique = true, length = 64)
	private String senha;

	@Column(name = "funcionario_salario")
	private Double salario;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "clinica_id")
	private Clinica clinica;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

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