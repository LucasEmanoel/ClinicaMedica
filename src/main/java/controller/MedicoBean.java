package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.entidades.Medico;

@ManagedBean
@ViewScoped
public class MedicoBean  implements Serializable{
	
	private Medico medico;
	
	public MedicoBean() {
		medico = new Medico();
	}
	public String salvar() {
		return "inicio.xhtml?faces-redirect=true";
	}
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	

}
