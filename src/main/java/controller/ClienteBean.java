package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.entidades.Cliente;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
	
	private Cliente user;
	
	public ClienteBean() {
		user = new Cliente();
	}
	
	
	public String salvar(){
		return "inicio.xhtml?faces-redirect=true";
	}

	public Cliente getUser() {
		return user;
	}

	public void setUser(Cliente user) {
		this.user = user;
	}
	
		
}
