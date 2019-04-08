package model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Pagamento")
@Table(name = "pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pagamento_id", nullable = false)
	private Long id;

	@Column(name = "pagamento_valor", nullable = false)
	private Double valor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "consulta_id", nullable = false)
	private Consulta consulta;

	public Pagamento(Double valor) {
		super();
		this.valor = valor;
	}
	public Pagamento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
