package model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Ambulatorio")
@Table(name = "ambulatorio")

public class Ambulatorio implements Serializable{

	private static final long serialVersionUID = -8625558677877133470L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ambulatorio_id")
	private Long id;

	@Column(name = "ambulatorio_numero", nullable = false, unique=true)
	private Integer numero;

	@Column(name = "ambulatorio_andar", nullable = false)
	private Integer andar;

	@OneToOne(fetch = FetchType.EAGER)
	private Secretaria secretaria;

	@OneToOne(fetch = FetchType.EAGER)
	private Medico medico;

	@OneToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	public Ambulatorio(Integer numero, Integer andar) {
		super();
		this.numero = numero;
		this.andar = andar;
	}

	public Ambulatorio() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAndar() {
		return andar;
	}

	public void setAndar(Integer andar) {
		this.andar = andar;
	}

	public Secretaria getSecretaria() {
		return secretaria;
	}

	public void setSecretaria(Secretaria secretaria) {
		this.secretaria = secretaria;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Ambulatorio other = (Ambulatorio) obj;
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}
	
}