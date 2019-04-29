package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.ClienteModel;
import model.ClinicaModel;
import model.entidades.Clinica;
import model.entidades.Endereco;

@ManagedBean
@SessionScoped
public class ClinicaBean  implements Serializable{

	private Clinica clinica;

	public ClinicaBean() {
		clinica = new Clinica();
		clinica.setEndereco(new Endereco());

	}

	public String salvar() {
		ClinicaModel cm = new ClinicaModel();
		
		try {
			if(cm.registrarClinica(this.clinica)) {
				return "ClinicaView?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Clinica getUser() {
		return this.clinica;
	}

	public void setUser(Clinica clinica) {
		this.clinica = clinica;
	}

}
