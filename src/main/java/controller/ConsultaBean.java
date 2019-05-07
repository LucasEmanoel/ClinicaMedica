package controller;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import model.ConsultaModel;
import model.entidades.Consulta;

@ManagedBean(name = "consultaView")
@ViewScoped
public class ConsultaBean implements Serializable{
	
	private Consulta consulta;
	private SimpleDateFormat sdf;
	private List<Consulta> consultas;
	private List<Consulta> consultasEmAtendimento;
	private List<Consulta> consultasConcluidas;
	private Consulta selecionada;
	private ConsultaModel cm;

	public ConsultaBean() {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		consultasEmAtendimento = new ArrayList<Consulta>();
		consultasConcluidas = new ArrayList<Consulta>();
		cm = new ConsultaModel();
		consultas = retornaTudo();
	}

	public String salvar() {
		try {
			if(cm.registrarConsulta(this.consulta)) {
				return "ClienteView?faces-redirect=true";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Consulta> retornaTudo() {
		try {
			return cm.findConsultaPorData(sdf.format(new Date(System.currentTimeMillis())));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void onConsultaAtendimento(DragDropEvent ddEvent) {
		Consulta con = ((Consulta) ddEvent.getData());

		consultasEmAtendimento.add(con);
		consultas.remove(con);
	}

	public void onConsultaConcluida(DragDropEvent ddEvent) {
		Consulta con = ((Consulta) ddEvent.getData());

		consultasConcluidas.add(con);
		consultasEmAtendimento.remove(con);
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public List<Consulta> getConsultasEmAtendimento() {
		return consultasEmAtendimento;
	}

	public void setConsultasEmAtendimento(List<Consulta> consultasEmAtendimento) {
		this.consultasEmAtendimento = consultasEmAtendimento;
	}

	public List<Consulta> getConsultasConcluidas() {
		return consultasConcluidas;
	}

	public void setConsultasConcluidas(List<Consulta> consultasConcluidas) {
		this.consultasConcluidas = consultasConcluidas;
	}

	public Consulta getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Consulta selecionada) {
		this.selecionada = selecionada;
	}
}