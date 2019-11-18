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
		Object o = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil");
		try {
			if(o.getClass().equals(Medico.class) || o.getClass().equals(Secretaria.class)) {
				this.consultas = cm.findTodasConsultas();
			
			} else {
				Cliente cli = (Cliente) o;
				
					this.consultas = this.cm.findConsultaPorCpfCliente(cli.getCpf());
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
