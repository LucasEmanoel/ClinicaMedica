package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.ClinicaModel;
import model.MedicoModel;
import model.SecretariaModel;
import model.entidades.Clinica;
import model.entidades.Funcionario;
import model.entidades.Medico;
import model.entidades.Secretaria;

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

	public String atualizarClinica() throws Exception {
		this.cm.atualizarClinica(this.userSessao);
		return "users/PerfilClinicaView?faces-redirect=true";
			
	}
	public String deletarClinica() throws Exception {
		this.cm.removerClinica(this.userSessao);
		return "LoginView?faces-redirect=true";
	}
	
	public void deletarFuncionario() {
		
		MedicoModel md = new MedicoModel();
		SecretariaModel sm = new SecretariaModel();
		
		try {
			if(this.selecionado instanceof Medico) {
				Medico m = (Medico) this.selecionado;
			
				md.removerMedico(m);
			
			} else {
				Secretaria a = (Secretaria) this.selecionado;
				
				sm.removerSecretaria(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
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