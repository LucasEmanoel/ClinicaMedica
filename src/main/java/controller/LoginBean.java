package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.UsuarioModel;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Medico;
import model.entidades.Pessoa;
import model.entidades.Secretaria;
import model.exceptions.ClinicaMedicaException;

@ManagedBean
@ViewScoped
public class LoginBean  implements Serializable{

	private Pessoa user;
	
	public LoginBean() {
		user = new Pessoa();
	}
	public String logar() {
		UsuarioModel um = new UsuarioModel();
		try {
			Object comparador = um.logar(user.getEmail(), user.getSenha());
			
			if(comparador instanceof Cliente) {
				return "telaCliente?faces-redirect=true";
			}else if(comparador instanceof Medico) {
				return "telaMedico?faces-redirect=true";
			}else if(comparador instanceof Secretaria) {
				return "telaSecretaria?faces-redirect=true";
			}else if(comparador instanceof Clinica) {
				return "telaClinica?faces-redirect=true";
			}
		} catch (ClinicaMedicaException e) {
			e.printStackTrace();
		}
		return "Login / Senha Incorretos!!";
	}
	
	public Pessoa getUser() {
		return user;
	}

	public void setUser(Pessoa user) {
		this.user = user;
	}
	

}