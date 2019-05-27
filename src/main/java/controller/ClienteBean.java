package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.ClienteModel;
import model.MedicoModel;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Consulta;
import model.entidades.Medico;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ClienteModel cm;
	private Cliente user = new Cliente();
	
	private List<Medico> medicos;
	private List<Clinica> clinicas;
	private Clinica selecionada;
	
	private Consulta con = new Consulta();
	
	
	public ClienteBean() {
		this.cm = new ClienteModel();
		this.clinicas = new ClinicaBean().retornaTodos();
	}
	
	
	public String salvar(){
		try {
			
			cm.registrarCliente(this.user);
			return "ClienteView?faces-redirect=true";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String atualizar() {
		try {
			if (cm.atualizarCliente(this.user)) {
				return "ClienteView?faces-redirect=true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deletar() {
		try {
			if (cm.removerCliente(this.user)) {
				return "inicio?faces-redirect=true";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void retornaMedicos() {
		try {
			this.medicos = new MedicoModel().encontrarMedicoPorClinica(this.selecionada);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Cliente getUser() {
		return user;
	}

	public void setUser(Cliente user) {
		this.user = user;
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
	
	
		
}
