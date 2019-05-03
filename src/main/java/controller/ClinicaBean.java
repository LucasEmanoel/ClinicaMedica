package controller;

import java.io.Serializable;
import java.util.ArrayList;

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

	public ClinicaBean() {
		clinica = new Clinica();
		clinica.setEndereco(new Endereco());
		clinica.setFuncionarios(new ArrayList<Funcionario>());
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
