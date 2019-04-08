package model.entidades;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Prontuario")
@Table(name = "prontuario")
public class Prontuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prontuario_id", nullable = false)
	private Long id;

	@Column(name = "prontuario_diag", length = 128, nullable = false)
	private String diagnostico;

	@Column(name = "prontuario_data", nullable = false)
	private Date data;

	@OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Medicamento> medicamento;

	@OneToOne(fetch = FetchType.EAGER)
	private Encaminhamento encaminhamento;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medico_id", nullable = false)
	private Medico medico;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
		this.medicamento.add(medicamento);
	}

	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento,
			Encaminhamento encaminhamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
		this.medicamento.add(medicamento);
		this.encaminhamento = encaminhamento;
	}
	public Prontuario() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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