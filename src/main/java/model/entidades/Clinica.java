package model.entidades;

public class Clinica {
	private Long id;
	private String email;
	private Telefone telefone;
	private Endereco endereco;
	
	public Clinica(String email, Telefone telefone, Endereco endereco) {
		super();
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
