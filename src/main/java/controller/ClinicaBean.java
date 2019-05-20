package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.ClinicaModel;
import model.entidades.Clinica;
import model.entidades.Funcionario;
import model.entidades.Pessoa;

@ManagedBean
@SessionScoped
public class ClinicaBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private ClinicaModel cm;
	private Clinica clinica = new Clinica();
	
	private List<Pessoa> funcionarios;
	private Funcionario selecionado;
	

	public ClinicaBean() {
		cm = new ClinicaModel();
		funcionarios = cm.encontrarTodosFuncionarios(this.clinica);
	}

	public String salvar() {
		try {
			
			cm.registrarClinica(this.clinica);
			return "ClinicaView?faces-redirect=true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String atualizar() {
		try {
			
			cm.atualizarClinica(this.clinica);
			return "ClinicaView?faces-redirect=true";
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deletar() {
		try {
			
			cm.removerClinica(this.clinica);
			return "inicio?faces-redirect=true";
			
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

	public List<Pessoa> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Pessoa> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ClinicaModel getCm() {
		return cm;
	}

	public void setCm(ClinicaModel cm) {
		this.cm = cm;
	}
	

}
