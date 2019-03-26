package model.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PRONTUARIO")
public class Prontuario {
	
	@Column(length=128, nullable=false)
	private String diagnostico;
	
	@OneToMany(mappedBy="prontuario")
	private List<Medicamento> medicamento;
	
	@OneToOne
	@JoinColumn(name="encaminhamento_id", referencedColumnName="id")
	private Encaminhamento encaminhamento;
	
	@ManyToOne
	@JoinColumn(name="medico_id")
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
		this.medicamento.add(medicamento);
	}

	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento, Encaminhamento encaminhamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
		this.medicamento.add(medicamento);
		this.encaminhamento = encaminhamento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Encaminhamento getEncaminhamento() {
		return encaminhamento;
	}

	public void setEncaminhamento(Encaminhamento encaminhamento) {
		this.encaminhamento = encaminhamento;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}