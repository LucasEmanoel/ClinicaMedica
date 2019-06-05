package model.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Consulta")
@Table(name = "consulta")
public class Consulta implements Serializable {

	private static final long serialVersionUID = 3479343146492919231L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consulta_id")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	private Cliente cliente;

	@ManyToOne(fetch = FetchType.EAGER)
	private Medico medico;

	@ManyToOne
	private Ambulatorio ambulatorio;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Pagamento pagamento;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, targetEntity = Medicamento.class)
	@JoinTable(name = "prescricao", joinColumns = @JoinColumn(name = "consulta_id", referencedColumnName = "consulta_id"),
				inverseJoinColumns = @JoinColumn(name = "medicamento_id", referencedColumnName = "medicamento_id"))
	private List<Medicamento> medicamentos;

	@Column(name = "consulta_descricao", length = 128)
	private String descricao;

	@Column(name = "consulta_data", nullable = false)
	private Calendar data;

	public Consulta() {
		this.ambulatorio = new Ambulatorio();
		this.cliente = new Cliente();
		this.data = null;
		this.medicamentos = new ArrayList<Medicamento>();
		this.medico = new Medico();
		this.pagamento = new Pagamento();
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

	public Ambulatorio getAmbulatorio() {
		return ambulatorio;
	}

	public void setAmbulatorio(Ambulatorio ambulatorio) {
		this.ambulatorio = ambulatorio;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}

	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Calendar getHorario() {
		return data;
	}

	public void setHorario(Calendar horario) {
		this.data = horario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ambulatorio == null) ? 0 : ambulatorio.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
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
		Consulta other = (Consulta) obj;
		if (ambulatorio == null) {
			if (other.ambulatorio != null)
				return false;
		} else if (!ambulatorio.equals(other.ambulatorio))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		return true;
	}

}