package model.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Medico")
@Table(name = "medico")
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Funcionario {

	@Column(name = "medico_crm", unique = true, nullable = false)
	private Long crm;

	@Column(name = "medico_meta_diaria", nullable = false)
	private Integer meta;

	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Especialidade> especialidades;

	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Consulta> consultas;


	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prontuario> prontuarios;

	public Medico(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco, String login,
			Double salario, String senha, Clinica clinica, Long crm, Integer meta) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setEndereco(endereco);
		this.setLogin(login);
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