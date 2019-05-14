package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.UsuarioModel;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Medico;
import model.entidades.Secretaria;
import model.exceptions.ClinicaMedicaException;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email;
	private String senha; 
	private UsuarioModel um;
	
	public LoginBean() {
		um = new UsuarioModel();
	}
	
	public String logar() {
		try {
			Object comparador = um.logar(this.email, this.senha);
			
			if(comparador instanceof Cliente) {
				return "ClienteView?faces-redirect=true";
			}else if(comparador instanceof Medico) {
				return "MedicoView?faces-redirect=true";
			}else if(comparador instanceof Secretaria) {
				return "SecretariaView?faces-redirect=true";
			}else if(comparador instanceof Clinica) {
				return "ClinicaView?faces-redirect=true";
			}else {
		       FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Email ou Senha Incorretos."));
			}
		} catch (ClinicaMedicaException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}