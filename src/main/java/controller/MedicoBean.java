package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.ClinicaModel;
import model.MedicoModel;
import model.entidades.Clinica;
import model.entidades.Medico;

@ManagedBean
@SessionScoped
public class MedicoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private MedicoModel mm;
	private Medico medico = new Medico();
	private Medico userSessao;
	
	private List<Clinica> clinicas;
	private Clinica selecionada;

	
	public MedicoBean() {
		mm = new MedicoModel();
		this.setUserSessao((Medico) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil"));
		this.retornaTodasClinicas();
	}
	public String salvar() {
		try {
			
			mm.registrarMedico(this.medico);
			return "MedicoView?faces-redirect=true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String atualizar() {
		try {
			
			mm.atualizarMedico(this.medico);
			return "MedicoView?faces-redirect=true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deletar() {
		try {
			
			mm.removerMedico(this.medico);
			return "MedicoView?faces-redirect=true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void retornaTodasClinicas() {
		try {
			this.clinicas = new ClinicaModel().encontrarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public Clinica getSelecionada() {
		return selecionada;
	}
	public void setSelecionada(Clinica selecionada) {
		this.selecionada = selecionada;
	}
	public MedicoModel getMm() {
		return mm;
	}
	public void setMm(MedicoModel mm) {
		this.mm = mm;
	}
	public Medico getUserSessao() {
		return userSessao;
	}
	public void setUserSessao(Medico userSessao) {
		this.userSessao = userSessao;
	}
	
}