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
	
	@Column(name="cliente_email" ,unique=true, nullable=false)
	private String email;
	
	@Column(name="cliente_login" ,unique=true, nullable=false)
	private String login;
	
	@Column(name="cliente_senha" ,unique=true, nullable=false)
	private String senha;
	
	@OneToMany(mappedBy="pessoa_id")
	private List<Consulta> consultas; 
	
	@OneToOne(mappedBy = "cliente_id_cliente")
	private Ambulatorio ambulatorio;
	
	@OneToMany(mappedBy="pessoa_id")
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
