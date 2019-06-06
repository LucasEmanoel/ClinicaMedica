package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.ClinicaModel;
import model.FuncionarioModel;
import model.entidades.Clinica;
import model.entidades.Funcionario;

@ManagedBean
@SessionScoped
public class ClinicaBean  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ClinicaModel cm;
	private Clinica userSessao;
	
	private List<Funcionario> funcionarios;
	private Funcionario selecionado;
	

	public ClinicaBean() {
		
		this.setUserSessao((Clinica) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil"));
		cm = new ClinicaModel();
		
		if(this.userSessao != null) {
			this.funcionarios = cm.encontrarTodosFuncionarios(this.userSessao);
		}
	}
	
	public void deletarFuncionario() {
		
		FuncionarioModel fm = new FuncionarioModel();
		
		try {
			fm.deletarFuncionario(this.selecionado);
			
		} catch (Exception e) {
			
		}
	}
	public void atualizarFuncionario() {
		
		FuncionarioModel fm = new FuncionarioModel();
		
		try {
			fm.atualizarFuncionario(this.selecionado);
			
		} catch (Exception e) {
			
		}
	}

	public Funcionario getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Funcionario selecionado) {
		this.selecionado = selecionado;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public ClinicaModel getCm() {
		return cm;
	}

	public void setCm(ClinicaModel cm) {
		this.cm = cm;
	}

	public Clinica getUserSessao() {
		return userSessao;
	}

	public void setUserSessao(Clinica userSessao) {
		this.userSessao = userSessao;
	}
}