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

	public String salvarClinica() {
		try {
			this.clinica.getPerfil().setDescricao("clinica");;
			new ClinicaModel().registrarClinica(this.clinica);
			return "LoginView?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String salvarCliente() {
		try {
			this.cliente.getPerfil().setDescricao("cliente");
			new ClienteModel().registrarCliente(this.cliente);
			return "LoginView?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String salvarSecretaria() {
		try {
			this.secretaria.getPerfil().setDescricao("secretaria");
			new SecretariaModel().registrarSecretaria(this.secretaria);
			return "LoginView?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public String salvarMedico() {
		try {
			this.medico.getPerfil().setDescricao("medico");
			new MedicoModel().registrarMedico(this.medico);
			return "LoginView?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void retornaTodasClinicas() {
		ClinicaModel cm = new ClinicaModel(); 
		
		try {
			this.setClinicas(cm.encontrarTodos());
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

	public List<Clinica> getClinicas() {
		return clinicas;
	}

	public void setClinicas(List<Clinica> clinicas) {
		this.clinicas = clinicas;
	}
}