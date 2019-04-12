package model.entidades;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ProntuarioPK implements Serializable{

	private static final long serialVersionUID = -6601747696271049372L;
	
	private Long medico;
	private Long cliente;
//	private Long medicamento;
	private Long encaminhamento;
	
	public ProntuarioPK(Long medico, Long cliente, Long medicamento, Long encaminhamento) {
		super();
		this.medico = medico;
		this.cliente = cliente;
//		this.medicamento = medicamento;
		this.encaminhamento = encaminhamento;
	}

	public Long getMedico() {
		return medico;
	}

	public void setMedico(Long medico) {
		this.medico = medico;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

//	public Long getMedicamento() {
//		return medicamento;
//	}
//
//	public void setMedicamento(Long medicamento) {
//		this.medicamento = medicamento;
//	}

	public Long getEncaminhamento() {
		return encaminhamento;
	}

	public void setEncaminhamento(Long encaminhamento) {
		this.encaminhamento = encaminhamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((encaminhamento == null) ? 0 : encaminhamento.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProntuarioPK other = (ProntuarioPK) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (encaminhamento == null) {
			if (other.encaminhamento != null)
				return false;
		} else if (!encaminhamento.equals(other.encaminhamento))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		return true;
	}

	
	

}