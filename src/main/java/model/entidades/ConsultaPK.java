package model.entidades;

import java.io.Serializable;


public class ConsultaPK implements Serializable{

	private static final long serialVersionUID = -457316106840473028L;
	
	private Long medico;
	private Long cliente;
	private Long ambulatorio;
	
	public ConsultaPK() {
	}

	public ConsultaPK(Long medico, Long cliente, Long ambulatorio) {
		super();
		this.medico = medico;
		this.cliente = cliente;
		this.ambulatorio = ambulatorio;
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

	public Long getAmbulatorio() {
		return ambulatorio;
	}

	public void setAmbulatorio(Long ambulatorio) {
		this.ambulatorio = ambulatorio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambulatorio == null) ? 0 : ambulatorio.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ConsultaPK other = (ConsultaPK) obj;
		if (ambulatorio == null) {
			if (other.ambulatorio != null) {
				return false;
			}
		} else if (!ambulatorio.equals(other.ambulatorio)) {
			return false;
		}
		if (cliente == null) {
			if (other.cliente != null) {
				return false;
			}
		} else if (!cliente.equals(other.cliente)) {
			return false;
		}
		if (medico == null) {
			if (other.medico != null) {
				return false;
			}
		} else if (!medico.equals(other.medico)) {
			return false;
		}
		return true;
	}


}
