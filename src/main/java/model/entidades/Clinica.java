package model.entidades;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLINICA")
public class Clinica {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="clinica_id", nullable=false)
	private Long id;
	
	@Column(name="clinica_cnpj",nullable=false, length=32)
	private String cnpj;
	
	@Column(name="clinica_email",nullable=false, length=64)
	private String email;
	
	@Column(name="clinica_tel1",length=32)
	private String telefone1;
	
	@Column(name="clinica_tel2",length=32)
	private String telefone2;
	
	@OneToOne
	@JoinColumn(name="clinica_id")
	private Endereco endereco;
	
	@OneToMany(mappedBy="clinica_id")
	private List<Funcionario> funcionarios;
	
	
	public Clinica(String email,String cnpj, String telefone, Endereco endereco) {
		this.email = email;
		this.cnpj = cnpj;
		this.telefone1 = telefone;
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
