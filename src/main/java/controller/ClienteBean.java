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
	private ClienteModel cm;
	
	public ClienteBean() {
		user = new Cliente();
		user.setEndereco(new Endereco());
		cm = new ClienteModel();
	}
	
	
	public String salvar(){
		try {
			if (cm.registrarCliente(this.user)) {
				return "ClienteView?faces-redirect=true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String atualizar() {
		try {
			if (cm.atualizarCliente(this.user)) {
				return "ClienteView?faces-redirect=true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deletar() {
		try {
			if (cm.removerCliente(this.user)) {
				return "inicio?faces-redirect=true";
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
