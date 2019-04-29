package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.MedicoModel;
import model.entidades.Clinica;
import model.entidades.Endereco;
import model.entidades.Medico;

@ManagedBean
@SessionScoped
public class MedicoBean  implements Serializable{
	
	private Medico medico;
	
	public MedicoBean() {
		medico = new Medico();
		medico.setClinica(new Clinica());
		medico.setEndereco(new Endereco());
	}
	public String salvar() {
		MedicoModel mm = new MedicoModel();

		try {
			if(mm.registrarMedico(this.medico)){
				return "MedicoView?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	

}
