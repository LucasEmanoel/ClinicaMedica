package model.entidades;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue(value = "SECRETARIA")
public class Secretaria extends Funcionario {
	
	private String qualificacao;
	
	public Secretaria(String nome, String cpf, String rg, Integer idade, Telefone telefone, Endereco endereco, Long coren,Clinica clinica, String qualificacao) {
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
