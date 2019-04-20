package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.entidades.Pessoa;

@ManagedBean
@RequestScoped
public class LoginBean {

	private Pessoa user;

	public LoginBean() {
		user = new Pessoa();
	}
	public String logar() {
		return "paginaUser";
	}
	public Pessoa getUser() {
		return user;
	}

	public void setUser(Pessoa user) {
		this.user = user;
	}
	

}