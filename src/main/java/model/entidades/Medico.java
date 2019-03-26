package model.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEDICO")
@DiscriminatorValue(value = "MEDICO")
public class Medico extends Funcionario {
	
	@Column(unique=true, nullable=false)
	private Long crm;
	
	@OneToMany(mappedBy="medico")
	private List<Especialidade> especialidades;
	
	@OneToMany(mappedBy="medico")
	private List<Consulta> consultas;
	
	@OneToOne(mappedBy = "medico")
	private Ambulatorio ambulatorio;
	
	@OneToMany(mappedBy="medico")
	private List<Prontuario> prontuarios;
	
	
	public Medico(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco, String login, Double salario, String senha, Long crm,Clinica clinica,  Especialidade especialidade) {
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
	}
	public Medico(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco, String login, String senha,Double salario,Clinica clinica, Long crm) {
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
	}

	public Long getCrm() {
		return crm;
	}

	public void setCrm(Long crm) {
		this.crm = crm;
	}
}