package model.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENTE")
@DiscriminatorValue(value = "CLIENTE")
public class Cliente extends Pessoa {
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(unique=true, nullable=false)
	private String login;
	
	@Column(unique=true, nullable=false)
	private String senha;
	
	@OneToMany(mappedBy="cliente")
	private List<Consulta> consultas; 
	
	@OneToOne(mappedBy = "cliente")
	private Ambulatorio ambulatorio;
	
	@OneToMany(mappedBy="cliente")
	private List<Prontuario> prontuarios;
	
	
	public Cliente(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco, String login, String senha) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setTelefone1(telefone);
		this.setEndereco(endereco);
		this.login = login;
		this.senha = senha;
	}

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
}
