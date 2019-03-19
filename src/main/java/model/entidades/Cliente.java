package model.entidades;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	
	private String login;
	private String senha;
	private Convenio convenio;
	
	public Cliente(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}
	
	public Cliente(String login, String senha, Convenio convenio) {
		super();
		this.login = login;
		this.senha = senha;
		this.convenio = convenio;
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

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
	
	
}
