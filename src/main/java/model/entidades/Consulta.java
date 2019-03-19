package model.entidades;

import java.sql.Time;
import java.util.Date;

public class Consulta {
	
	private Long id;
	private Cliente cliente;
	private Medico medico;
	private Date data;
	private Time horario;

	public Consulta(Cliente cliente, Medico medico, Date data, Time horario) {
		super();
		this.cliente = cliente;
		this.medico = medico;
		this.data = data;
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}
	

	
	
	
	
	
}
