
package model.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Secretaria")
@DiscriminatorValue(value = "SECRETARIA")
public class Secretaria extends Funcionario implements Serializable {

	private static final long serialVersionUID = -4298092151407776552L;

	@Column(name = "secretaria_qualificacao", length = 128)
	private String qualificacao;

	public Secretaria(String nome, String cpf, String rg, Integer idade, String telefone, Endereco endereco,
			String email, String senha, Double salario, Long coren, Clinica clinica, String qualificacao) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setEndereco(endereco);
		this.setEmail(email);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setClinica(clinica);
		this.qualificacao = qualificacao;
	}

	public Secretaria() {
		this.setClinica(new Clinica());
		this.setEndereco(new Endereco());
	}

	public String getQualificacao() {
		return qualificacao;
	}

	public void setQualificacao(String qualificacao) {
		this.qualificacao = qualificacao;
	}
}