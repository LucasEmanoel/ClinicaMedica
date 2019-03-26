
package model.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SECRETARIA")
@DiscriminatorValue(value = "SECRETARIA")
public class Secretaria extends Funcionario {
	
	@Column(nullable=false, length=128)
	private String qualificacao;
	
	@OneToOne(mappedBy = "secretaria")
	private Ambulatorio ambulatorio;
	
	public Secretaria(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco, Long coren,Clinica clinica, String qualificacao) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setEndereco(endereco);
		this.setClinica(clinica);
		this.qualificacao = qualificacao;
	}
	
	public String getQualificacao() {
		return qualificacao;
	}
	public void setQualificacao(String qualificacao) {
		this.qualificacao = qualificacao;
	}
	
	
	
	
	
	
}
