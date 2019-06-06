package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.ClienteModel;
import model.ClinicaModel;
import model.MedicoModel;
import model.SecretariaModel;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Medico;
import model.entidades.Secretaria;

@ManagedBean
@ViewScoped
public class RegistroBean {
	
	private Clinica clinica = new Clinica();
	private Cliente cliente = new Cliente();
	private Secretaria secretaria = new Secretaria();
	private Medico medico = new Medico();
	private List<Clinica> clinicas;
	
	public RegistroBean() {
		this.retornaTodasClinicas();
	}
	
	public String salvar() {
		if(this.clinica != null) {
			try {
				new ClinicaModel().registrarClinica(this.clinica);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(this.cliente != null) {
			try {
				new ClienteModel().registrarCliente(this.cliente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(this.secretaria != null) {
			try {
				new SecretariaModel().registrarSecretaria(this.secretaria);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(this.medico != null) {
			try {
				new MedicoModel().registrarMedico(this.medico);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "LoginView?faces-redirect=true";
	}
	
	public void retornaTodasClinicas() {
		try {
			this.setClinicas(new ClinicaModel().encontrarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
	}


	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Clinica> registroBean() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}
}