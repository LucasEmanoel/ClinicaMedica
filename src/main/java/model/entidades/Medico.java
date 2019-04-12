package model.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name = "Medico")
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Funcionario implements Serializable{

	private static final long serialVersionUID = 7613514159588447175L;

	@Column(name = "medico_crm", unique = true)
	private Long crm;

	@Column(name = "medico_meta_diaria")
	private Integer meta;

	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Especialidade.class)
	@JoinTable(
			name="medico_especialidade",
			joinColumns=@JoinColumn(name="pessoa_id", referencedColumnName="pessoa_id"),
			inverseJoinColumns=@JoinColumn(name="especialidade_id", referencedColumnName="especialidade_id"))
	private List<Especialidade> especialidades;

	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;

	@OneToMany(mappedBy = "medico", orphanRemoval = true)
	private List<Prontuario> prontuarios;

	public Medico(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco, String email,
			Double salario, String senha, Clinica clinica, Long crm, Integer meta) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setClinica(clinica);
		this.crm = crm;
		this.meta = meta;
	}

	public Medico() {

	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}

	public Integer getMeta() {
		return meta;
	}

	public void setMeta(Integer meta) {
		this.meta = meta;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}


	public List<Prontuario> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<Prontuario> prontuarios) {
		this.prontuarios = prontuarios;
	}

}