package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.entidades.Cliente;

@ManagedBean
@SessionScoped
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
