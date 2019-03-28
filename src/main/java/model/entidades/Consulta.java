package model.entidades;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONSULTA")
public class Consulta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="consulta_id", nullable=false)
	private Long id;
	
	@Column(name="consulta_data",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name="consulta_horario",nullable=false)
	@Temporal(TemporalType.TIME)
	private Time horario;
	
	@ManyToOne
	@JoinColumn(name="cliente_id", nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="medico_id", nullable=false)
	private Medico medico;
	
	@OneToMany(mappedBy="consulta_id")
	private List<Pagamento> pagamento;

	public Consulta(Cliente cliente, Medico medico, Date data, Time horario) {
		super();
		this.cliente = cliente;
		this.medico = medico;
		this.data = data;
		this.horario = horario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getHorario() {
		return horario;
	}

	public void setHorario(Time horario) {
		this.horario = horario;
	}
}
