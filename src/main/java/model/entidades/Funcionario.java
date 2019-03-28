package model.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIO")
@DiscriminatorValue( value="FUNCIONARIO" )
public abstract class Funcionario extends Pessoa {
	
	@Column(name="funcionario_id", unique=true, nullable=false, length=64)
	private String login;
	
	@Column(name="funcionario_senha", unique=true, nullable=false, length=64)
	private String senha;
	
	@Column(name="funcionario_salario", nullable=false)
	private Double salario;
	
	@ManyToOne
	@JoinColumn(name="clinica_id", nullable=false)
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
