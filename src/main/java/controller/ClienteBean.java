package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.ClienteModel;
import model.entidades.Cliente;
import model.entidades.Endereco;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{
	
	private Cliente user;
	
	public ClienteBean() {
		user = new Cliente();
		user.setEndereco(new Endereco());
	}
	
	
	public String salvar(){
		ClienteModel cm = new ClienteModel();
		
		try {
			if (cm.registrarCliente(this.user)) {
				return "ClienteView?faces-redirect=true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public Cliente getUser() {
		return user;
	}

	public void setUser(Cliente user) {
		this.user = user;
	}
	
		
}
