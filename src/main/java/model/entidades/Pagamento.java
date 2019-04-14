package model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pagamento")
@Table(name = "pagamento")
public class Pagamento implements Serializable {

	private static final long serialVersionUID = -1640816264192336507L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pagamento_id")
	private Long id;

	@Column(name = "pagamento_valor", nullable = false)
	private Double valor;

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
