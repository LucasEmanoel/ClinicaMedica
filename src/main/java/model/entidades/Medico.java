package model.entidades;

public class Medico extends Funcionario {
	private Long crm;
	private Especialidade especialidade;
	
	public Medico(String nome, String cpf, String rg, Integer idade, Telefone telefone, Endereco endereco, String login, Double salario, String senha, Long crm,Clinica clinica,  Especialidade especialidade) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setTelefone(telefone);
		this.setEndereco(endereco);
		this.setLogin(login);
		this.setSenha(senha);
		this.setSalario(salario);
		this.setClinica(clinica);
		this.crm = crm;
		this.especialidade = especialidade;
	}
	public Medico(String nome, String cpf, String rg, Integer idade, Telefone telefone, Endereco endereco, String login, String senha,Double salario,Clinica clinica, Long crm) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setIdade(idade);
		this.setTelefone(telefone);
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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
}