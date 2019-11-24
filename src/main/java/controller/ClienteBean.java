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
	private LoginBean lb;
	private Cliente userSessao;
	
	public ClienteBean() {
		this.cm = new ClienteModel();
		this.lb = new LoginBean();
		this.setUserSessao((Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil"));
	}
	
	public String atualizarCliente() throws Exception {
		this.cm.atualizarCliente(this.userSessao);
		return "users/PerfilClienteView?faces-redirect=true";
	}
	
	public String deletarCliente() throws Exception {
		this.cm.removerCliente(this.userSessao);
		return "LoginView?faces-redirect=true";
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

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}
}