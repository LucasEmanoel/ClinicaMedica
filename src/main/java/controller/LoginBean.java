package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;

import model.UsuarioModel;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Funcionalidade;
import model.entidades.Medico;
import model.entidades.Pessoa;
import model.entidades.Secretaria;
import model.exceptions.ClinicaMedicaException;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String senha; 
	private UsuarioModel um;
	private DefaultMenuModel menuModel; 
	
	public LoginBean() {
		um = new UsuarioModel();
	}
	
	public DefaultMenuModel retornaMenu(Pessoa usuarioTemp) {
        DefaultMenuModel menuTemp = new DefaultMenuModel();
        
        for(Funcionalidade funcionalidade:usuarioTemp.getPerfil().getFuncionalidades()){
            DefaultMenuItem item = new DefaultMenuItem();
            item.setUrl(funcionalidade.getUrl());
            item.setValue(funcionalidade.getValor());
            menuTemp.addElement(item);
        }
        
        return menuTemp;
    }
	public String logar() {
		try {
			Object user = um.logar(this.email, this.senha);
			FacesContext con = FacesContext.getCurrentInstance();
			
			if(user instanceof Cliente) {
				
				con.getExternalContext().getSessionMap().put("perfil", (Cliente) user);
				return "users/ClienteView?faces-redirect=true"; 
				
			}else if(user instanceof Medico) {
				
				con.getExternalContext().getSessionMap().put("perfil", (Medico) user);
				return "users/MedicoView?faces-redirect=true";
				
			}else if(user instanceof Secretaria) {
				
				con.getExternalContext().getSessionMap().put("perfil", (Secretaria) user);
				return "users/SecretariaView?faces-redirect=true";
				
			}else if(user instanceof Clinica) {
				
				con.getExternalContext().getSessionMap().put("perfil", (Clinica) user);
				return "users/ClinicaView?faces-redirect=true";
				
			}else {
		       FacesContext.getCurrentInstance().addMessage(
		    		   null,
		    		   new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Email ou Senha Incorretos."));
			}
		} catch (ClinicaMedicaException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String deslogar() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "inicio?faces-redirect=true";
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

	public UsuarioModel getUm() {
		return um;
	}

	public void setUm(UsuarioModel um) {
		this.um = um;
	}

	public DefaultMenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(DefaultMenuModel menuModel) {
		this.menuModel = menuModel;
	}	
	
}