package model.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AMBULATORIO")
public class Ambulatorio {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ambulatorio_id", nullable=false)
	private Long id;
	
	@Column(name="ambulatorio_numero", nullable=false)
	private Integer numero;

	@Column(name="ambulatorio_andar", nullable=false)
	private Integer andar;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "secretaria_id_secretaria",  referencedColumnName = "pessoa_id")
	private Secretaria secretaria;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "medico_id_medico",  referencedColumnName = "pessoa_id")
	private Medico medico;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id_cliente",  referencedColumnName = "pessoa_id")
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
