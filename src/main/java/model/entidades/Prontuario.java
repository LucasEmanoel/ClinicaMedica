package model.entidades;

public class Prontuario {
	private String diagnostico;
	private Medicamento medicamento;
	private Encaminhamento encaminhamento;
	private Medico medico;
	private Cliente cliente;
	
	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
		this.medicamento = medicamento;
	}

	public Prontuario(Medico medico, Cliente cliente, String diagnostico, Medicamento medicamento, Encaminhamento encaminhamento) {
		this.medico = medico;
		this.cliente = cliente;
		this.diagnostico = diagnostico;
		this.medicamento = medicamento;
		this.encaminhamento = encaminhamento;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
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