package model.entidades;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Prontuario")
@Table(name = "prontuario")
@IdClass(ProntuarioPK.class)
public class Prontuario implements Serializable{

	private static final long serialVersionUID = -4638390367196707366L;

	@Column(name = "prontuario_diag", length = 128, nullable = false)
	private String diagnostico;

	@Column(name = "prontuario_data", nullable = false)
	private Date data;
	
//	@Id
//	@OneToMany(mappedBy = "prontuario", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<Medicamento> medicamento;
	
	@Id
	@OneToOne(fetch = FetchType.EAGER)
	private Encaminhamento encaminhamento;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
//		this.medicamento.add(medicamento);
	}

	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento,
			Encaminhamento encaminhamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
//		this.medicamento.add(medicamento);
		this.encaminhamento = encaminhamento;
	}
	public Prontuario() {
		
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

//	public List<Medicamento> getMedicamento() {
//		return medicamento;
//	}
//
//	public void setMedicamento(List<Medicamento> medicamento) {
//		this.medicamento = medicamento;
//	}

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