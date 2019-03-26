package model.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AMBULATORIO")
public class Ambulatorio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Integer numero;

	@Column(nullable=false)
	private Integer andar;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "secretaria_ambulatorio",
		joinColumns = { @JoinColumn(name="secretaria_id", referencedColumnName="id") },
		inverseJoinColumns = { @JoinColumn(name="ambulatorio_id", referencedColumnName="id") })
	private Secretaria secretaria;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "medico_ambulatorio",
	joinColumns = { @JoinColumn(name="medico_id", referencedColumnName="id") },
	inverseJoinColumns = { @JoinColumn(name="ambulatorio_id", referencedColumnName="id") })
	private Medico medico;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "cliente_ambulatorio",
	joinColumns = { @JoinColumn(name="cliente_id", referencedColumnName="id") },
	inverseJoinColumns = { @JoinColumn(name="ambulatorio_id", referencedColumnName="id") })
	private Cliente cliente;
	
	public Ambulatorio(Integer numero, Integer andar) {
		super();
		this.numero = numero;
		this.andar = andar;
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
	
	
	
}
