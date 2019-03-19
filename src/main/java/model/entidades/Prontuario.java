package model.entidades;

public class Prontuario {
	private Long id;
	private String diagnostico;
	private Medicamento medicamento;
	private Encaminhamento encaminhamento;
	
	public Prontuario(String diagnostico, Medicamento medicamento) {
		super();
		this.diagnostico = diagnostico;
		this.medicamento = medicamento;
	}

	public Prontuario(String diagnostico, Medicamento medicamento, Encaminhamento encaminhamento) {
		super();
		this.diagnostico = diagnostico;
		this.medicamento = medicamento;
		this.encaminhamento = encaminhamento;
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
	
	
	
	
	
	
	
	
}
