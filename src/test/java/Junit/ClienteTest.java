package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import model.dao.ClienteDao;
import model.entidades.Cliente;
import model.entidades.Endereco;
import model.entidades.Perfil;

public class ClienteTest {

	private ClienteDao cd;
	private Cliente cliente;
	private Cliente consulta;

	@Before
	public void inicializa() {
		this.cd = new ClienteDao();
		this.cliente = new Cliente();
		
		this.cliente.setCpf("12345");
		this.cliente.setId(2L);
		this.cliente.setEmail("cliente@gmail.com");
		this.cliente.setEndereco(new Endereco());
		this.cliente.getEndereco().setId(2L);
		this.cliente.getEndereco().setBairro("123");
		this.cliente.getEndereco().setCep("123");
		this.cliente.getEndereco().setRua("123");
		this.cliente.setIdade(25);
		this.cliente.setNome("Jeremy");
		this.cliente.setPerfil(new Perfil());
		this.cliente.getPerfil().setId(2L);
		this.cliente.getPerfil().setDescricao("perfil Cliente");
		this.cliente.setRg("123456");
		this.cliente.setSenha("123456");
		this.cliente.setTelefone1("123456");
		this.cliente.setTelefone2("123456");
	}

	@Test
	public void registerClientTest() {

		cd.salvar(cliente);
		
		this.consulta = cd.encontrarPorCpf("12345");

		assertEquals(consulta, cliente);
	}

	@Test
	public void editClientTest() {
		this.cliente.setNome("cliente atualizado");
		
		cd.atualizar(this.cliente);
		consulta = cd.encontrarPorCpf("12345");
		assertEquals(consulta, this.cliente);
	}

	@Test
	public void deleteClientTest() {
		cd.deletar(this.cliente);
		
		consulta = cd.encontrarPorCpf("12345");
		
		assertNull(consulta);
	}
}
