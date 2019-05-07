package controller;

import java.io.Serializable;
import java.util.List;

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
	private List<Clinica> clinicas;
	private MedicoModel mm;
	
	public MedicoBean() {
		medico = new Medico();
		medico.setClinica(new Clinica());
		medico.setEndereco(new Endereco());
		mm = new MedicoModel();
		this.clinicas = new ClinicaBean().retornaTodos();
	}
	public String salvar() {
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
	public List<Clinica> getClinicas() {
		return clinicas;
	}
	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}
}