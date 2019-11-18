package Junit;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.ClienteDao;
import model.entidades.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {

	private ClienteDao cd;
	private Cliente cli;
	
	@Before
	public void inicializa() {
		this.cd = new ClienteDao();
		
	}
	
	@Test
	public void _1registerClientTest1() {

		this.cli = new Cliente();
		this.cli.setCpf("2");
		this.cli.setEmail("cliente@gmail.com");
		this.cli.getEndereco().setBairro("2");
		this.cli.getEndereco().setCep("2");
		this.cli.getEndereco().setRua("2");
		this.cli.setIdade(25);
		this.cli.setNome("Jeremy");
		this.cli.getPerfil().setDescricao("cliente");
		this.cli.setRg("2");
		this.cli.setSenha("2");
		this.cli.setTelefone1("2");
		this.cli.setTelefone2("2");
		
		Cliente resultado = cd.salvar(this.cli);

		assertEquals(resultado, this.cli);
	}
	
	@Test
	public void _2updateClientTest() {
		
		this.cli = cd.encontrarPorCpf("2");
		this.cli.setNome("Cliente Atualizado");
		
		Cliente resultado = cd.atualizar(this.cli);
		
		assertEquals(resultado, this.cli);
	}
	
	@Test
	public void _3deleteClientTest() {
		this.cli = cd.encontrarPorCpf("2");
		
		boolean resultado = cd.deletar(this.cli);
		
		assertTrue(resultado);
	}

}
