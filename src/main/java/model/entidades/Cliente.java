package model.entidades;

import javax.persistence.Entity;

@Entity
public class Cliente extends Pessoa {
	
	private String login;
	private String senha;
	
	public Cliente(String nome, String cpf, String rg, Integer idade, Telefone telefone, Endereco endereco, String login, String senha) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setTelefone(telefone);
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
