
package model.entidades;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Secretaria")
@Table(name = "secretaria")
@DiscriminatorValue(value = "SECRETARIA")
public class Secretaria extends Funcionario {

	@Column(name = "secretaria_qualificacao", length = 128)
	private String qualificacao;

	public Secretaria(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco,String login, String senha, Double salario,
			Long coren, Clinica clinica, String qualificacao) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setEndereco(endereco);
		this.setLogin(login);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setClinica(clinica);
		this.qualificacao = qualificacao;
	}
	public Secretaria() {
		
	}

	public String getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(String qualificacao) {
		this.qualificacao = qualificacao;
	}
}