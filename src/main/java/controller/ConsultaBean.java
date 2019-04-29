package controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import model.entidades.Cliente;
import model.entidades.Consulta;
import model.entidades.Endereco;

@ManagedBean(name = "consultaView")
@ViewScoped
public class ConsultaBean {
	
	private List<Consulta> consultas;
	private List<Consulta> consultasEmAtendimento;
	private List<Consulta> consultasConcluidas;
	private Consulta selecionada;
	
	public ConsultaBean() {
		consultas = new ArrayList<Consulta>();
		Cliente c = new Cliente("lucas", "153", "21", 19, "15511", new Endereco("rua", "centro", "bairro"), "lucas@", "123");
		Consulta con = new Consulta("tosse", new Date(15243L), new Time(15530L));
		con.setCliente(c);
		consultas.add(con);
		consultasEmAtendimento = new ArrayList<Consulta>();
		consultasConcluidas = new ArrayList<Consulta>();
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