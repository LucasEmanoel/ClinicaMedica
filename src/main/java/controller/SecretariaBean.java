package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.SecretariaModel;
import model.entidades.Clinica;
import model.entidades.Endereco;
import model.entidades.Secretaria;

@ManagedBean
@SessionScoped
public class SecretariaBean  implements Serializable{
	
	private Secretaria secretaria;
	
	public SecretariaBean() {
		secretaria = new Secretaria();
		secretaria.setClinica(new Clinica());
		secretaria.setEndereco(new Endereco());
	}

	public String salvar() {
		SecretariaModel sm = new SecretariaModel();
		
		try {
			if(sm.registrarSecretaria(this.secretaria)){
				return "SecretariaView?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}
	
	

}
