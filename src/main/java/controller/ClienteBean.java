package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.ClienteModel;
import model.entidades.Cliente;
import model.entidades.Clinica;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Cliente user = new Cliente();
	private ClienteModel cm;
	private List<Clinica> clinicas;
	
	public ClienteBean() {
		this.cm = new ClienteModel();
		this.clinicas = new ClinicaBean().retornaTodos();
	}
	
	
	public String salvar(){
		try {
			
			cm.registrarCliente(this.user);
			return "ClienteView?faces-redirect=true";
			
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


	public ClienteModel getCm() {
		return cm;
	}


	public void setCm(ClienteModel cm) {
		this.cm = cm;
	}


	public List<Clinica> getClinicas() {
		return clinicas;
	}


	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}
	
	
		
}
