package model.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity(name = "Cliente")
@DiscriminatorValue(value = "CLIENTE")
public class Cliente extends Pessoa implements Serializable{

	private static final long serialVersionUID = -9113760811424501108L;

	@Column(name = "cliente_email", unique = true)
	private String email;

	@Column(name = "cliente_senha", unique = true)
	private String senha;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Consulta> consultas;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prontuario> prontuarios;

	public Cliente(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco, String email, String senha) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setTelefone1(telefone);
		this.setEndereco(endereco);
		this.email = email;
		this.senha = senha;
	}
	public Cliente() {
		
	}
	
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

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}
	
	
}