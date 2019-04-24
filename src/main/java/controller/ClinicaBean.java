package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.entidades.Clinica;

@ManagedBean
@SessionScoped
public class ClinicaBean  implements Serializable{

	private Clinica clinica;

	public ClinicaBean() {

	}

	public String salvar() {
		return "inicio.xhtml?faces-redirect=true";
	}

	public Clinica getUser() {
		return this.clinica;
	}

	public void setUser(Clinica clinica) {
		this.clinica = clinica;
	}

}
