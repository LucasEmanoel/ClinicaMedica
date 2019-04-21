package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.entidades.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean {
	
	private Cliente user;
	
	public ClienteBean() {
		
	}
	
	
	public String salvar(){
		return "inicio.xhtml";
	}

	public Cliente getUser() {
		return user;
	}

	public void setUser(Cliente user) {
		this.user = user;
	}
	
		
}
