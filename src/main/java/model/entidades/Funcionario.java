package model.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Funcionario")
@Table(name = "funcionario")
@DiscriminatorValue(value = "FUNCIONARIO")
public abstract class Funcionario extends Pessoa {
		
	@Column(name = "funcionario_login", unique = true, length = 64)
	private String login;

	@Column(name = "funcionario_senha", unique = true, length = 64)
	private String senha;

	@Column(name = "funcionario_salario")
	private Double salario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinica_id")
	private Clinica clinica;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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