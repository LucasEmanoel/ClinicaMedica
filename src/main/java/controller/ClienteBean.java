package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.ClienteModel;
import model.ClinicaModel;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Consulta;
import model.entidades.Medico;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ClienteModel cm;
	private Cliente userSessao;
	
	private List<Medico> medicos;
	private List<Clinica> clinicas;
	private Clinica selecionada;
	
	private Consulta con = new Consulta();
	
	public ClienteBean() {
		this.cm = new ClienteModel();
		this.setUserSessao((Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil"));
		this.retornaTodasClinicas();
	}

	
	public void retornaTodasClinicas() {
		try {
			this.clinicas = new ClinicaModel().encontrarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void retornaMedicos() {
		try {
			this.medicos = new ClinicaModel().encontrarMedicoPorClinica(this.selecionada);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ClienteModel getCm() {
		return cm;
	}


	public void setCm(ClienteModel cm) {
		this.cm = cm;
	}

	public Consulta getCon() {
		return con;
	}

	public void setCon(Consulta con) {
		this.con = con;
	}

	public Clinica getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Clinica selecionada) {
		this.selecionada = selecionada;
	}

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public Cliente getUserSessao() {
		return userSessao;
	}

	public void setUserSessao(Cliente userSessao) {
		this.userSessao = userSessao;
	}
}