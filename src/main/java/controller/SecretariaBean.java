package controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.ClinicaModel;
import model.SecretariaModel;
import model.entidades.Clinica;
import model.entidades.Secretaria;

@ManagedBean
@SessionScoped
public class SecretariaBean  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private SecretariaModel sm;
	private Secretaria secretaria = new Secretaria();
	private Secretaria userSessao;
	
	private List<Clinica> clinicas;
	private Clinica selecionada;
	
	
	public SecretariaBean() {
		this.sm = new SecretariaModel();
		this.setUserSessao((Secretaria) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil"));
		this.retornaTodasClinicas();
	}

	public String salvar() {
		try {
			sm.registrarSecretaria(this.secretaria);
			return "SecretariaView?faces-redirect=true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String atualizar() {
		try {
			
			sm.atualizarSecretaria(this.secretaria);
			return "SecretariaView?faces-redirect=true";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deletar() {
		try {
			
			sm.removerSecretaria(this.secretaria);
			return "SecretariaView?faces-redirect=true";

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
	
	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
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

	public SecretariaModel getSm() {
		return sm;
	}

	public void setSm(SecretariaModel sm) {
		this.sm = sm;
	}

	public Secretaria getUserSessao() {
		return userSessao;
	}

	public void setUserSessao(Secretaria userSessao) {
		this.userSessao = userSessao;
	}
	
}
