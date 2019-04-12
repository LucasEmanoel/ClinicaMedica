package model.entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Consulta")
@Table(name = "consulta")
public class Consulta implements Serializable{

	private static final long serialVersionUID = 3479343146492919231L;

	@EmbeddedId
	private ConsultaPK id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medico_id")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name="ambulatorio_id")
	private Ambulatorio ambulatorio;
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	@Column(name = "consulta_descricao", length=128)
	private String descricao;
	
	@Column(name = "consulta_data", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name = "consulta_horario", nullable = false)
	private Time horario;

	public Consulta(String descricao, Date data, Time horario) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.horario = horario;
	}
	public Consulta() {
		
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

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}