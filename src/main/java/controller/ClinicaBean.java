package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.ClinicaModel;
import model.entidades.Clinica;
import model.entidades.Endereco;
import model.entidades.Funcionario;

@ManagedBean
@SessionScoped
public class ClinicaBean  implements Serializable{

	private Clinica clinica;
	private Funcionario selecionado;
	private ClinicaModel cm;

	public ClinicaBean() {
		clinica = new Clinica();
		clinica.setEndereco(new Endereco());
		clinica.setFuncionarios(new ArrayList<Funcionario>());
		cm = new ClinicaModel();
	}

	public String salvar() {
		try {
			if(cm.registrarClinica(this.clinica)) {
				return "ClinicaView?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String atualizar() {
		try {
			if(cm.atualizarClinica(this.clinica)) {
				return "ClinicaView?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deletar() {
		try {
			if(cm.removerClinica(this.clinica)) {
				return "inicio?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Clinica> retornaTodos() {
		try {
			return cm.encontrarTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Funcionario getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Funcionario selecionado) {
		this.selecionado = selecionado;
	}
	

}
