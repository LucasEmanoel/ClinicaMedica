package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.entidades.Pessoa;

@ManagedBean
@ViewScoped
public class LoginBean {

	private Pessoa user;
	
	public LoginBean() {
		user = new Pessoa();
	}
	public String logar() {
		return "";
	}
	public Pessoa getUser() {
		return user;
	}

	public void setUser(Pessoa user) {
		this.user = user;
	}
	

}