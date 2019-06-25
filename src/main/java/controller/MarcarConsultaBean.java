package controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import model.ClinicaModel;
import model.ConsultaModel;
import model.entidades.Clinica;
import model.entidades.Consulta;
import model.entidades.Medico;

@ManagedBean(name = "consultaBean")
@ViewScoped
public class MarcarConsultaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Consulta con = new Consulta();
	private List<Medico> medicos;
	
	private List<Clinica> clinicas;
	private Clinica selecionada;
	
	public MarcarConsultaBean() {
		this.retornaTodasClinicas();
	}
	
	public void retornaTodasClinicas(  ) {
		try {
			this.setClinicas(new ClinicaModel().encontrarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void retornaMedicosPorClinica( AjaxBehaviorEvent event ) {
		
		try {
			
			this.medicos = new ClinicaModel().encontrarMedicoPorClinica(this.selecionada);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void marcarConsulta() {

		ConsultaModel conModel = new ConsultaModel();
		
		try {
			conModel.registrarConsulta(this.con);
		} catch (Exception e) {
		}
	}

	public Consulta getCon() {
		return con;
	}

	public void setCon(Consulta con) {
		this.con = con;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
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
	
	
}
