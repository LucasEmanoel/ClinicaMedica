package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import model.ConsultaModel;
import model.entidades.Cliente;
import model.entidades.Consulta;
import model.entidades.Medico;
import model.entidades.Pessoa;
import model.entidades.Secretaria;

@ManagedBean(name = "historicoBean")
@ViewScoped
public class HistoricoBean {
	
	ConsultaModel cm;
	private List<Consulta> consultas;
	private Consulta selecionada;
	
	public HistoricoBean() {
		cm = new ConsultaModel();
		this.listarPorUser();
	}
	
	public void listarPorUser() {
		Pessoa o = ((Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil"));
		
		if(o instanceof Medico || o instanceof Secretaria) {
			this.consultas = this.listarTodasConsultas();
		
		} else {
			this.consultas = this.consultaPorCliente((Cliente) o);
	
		}
	}
	
	public List<Consulta> listarTodasConsultas() {
		
		try {
			return cm.findTodasConsultas();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public List<Consulta> consultaPorCliente(Cliente cli) {
		
		try {
			return cm.findConsultaPorCpfCliente(cli.getCpf());
		} catch (Exception e) {
			return null;
		}
		
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Consulta selecionada) {
		this.selecionada = selecionada;
	}
	
	
}
