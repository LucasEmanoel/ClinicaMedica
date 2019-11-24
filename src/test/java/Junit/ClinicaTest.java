package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.ClinicaDao;
import model.entidades.Clinica;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClinicaTest {

	private ClinicaDao cd;
	private Clinica cli;
	
	@Before
	public void inicializa() {
		this.cd = new ClinicaDao();
		
	}

	@Test
	public void _1registerClinicaTest1() throws Exception {
		
		this.cli = new Clinica();
		this.cli.setCnpj("123");
		this.cli.setEmail("clinica@gmail.com");
		this.cli.getEndereco().setBairro("1");
		this.cli.getEndereco().setCep("1");
		this.cli.getEndereco().setRua("1");
		this.cli.setNome("clinica");
		this.cli.setSenha("1");
		this.cli.setIdade(30);
		this.cli.setTelefone1("1");
		this.cli.setTelefone2("1");
		this.cli.getPerfil().setDescricao("clinica");
		
		Clinica resultado = cd.salvar(this.cli);
		assertEquals(resultado, this.cli);

	}	
	
	@Test
	public void _2updateClinicaTest() {
		this.cli = cd.encontrarPorCnpj("123");
		this.cli.setNome("Clinica Atualizado");
		
		Clinica resultado = cd.atualizar(this.cli);
		
		assertEquals(resultado, this.cli);
	}
	
	@Ignore
	@Test
	public void _3deleteClinicaTest() {
		this.cli = cd.encontrarPorCnpj("123");
		
		boolean resultado = cd.deletar(this.cli);
		
		assertTrue(resultado);
	}
}
