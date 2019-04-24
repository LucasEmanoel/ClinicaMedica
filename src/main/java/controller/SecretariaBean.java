package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.entidades.Secretaria;

@ManagedBean
@SessionScoped
public class SecretariaBean  implements Serializable{
	
	private Secretaria secretaria;
	
	public SecretariaBean() {
		secretaria = new Secretaria();
	}

	public String salvar() {
		return "inicio.xhtml?faces-redirect=true";
	}
	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}
	
	

}
