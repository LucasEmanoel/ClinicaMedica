package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.ClienteModel;
import model.entidades.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ClienteModel cm;
	private Cliente userSessao;
	
	public ClienteBean() {
		this.cm = new ClienteModel();
		this.setUserSessao((Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil"));
	}

	
	public ClienteModel getCm() {
		return cm;
	}

	public void setCm(ClienteModel cm) {
		this.cm = cm;
	}

	public Cliente getUserSessao() {
		return userSessao;
	}

	public void setUserSessao(Cliente userSessao) {
		this.userSessao = userSessao;
	}
}