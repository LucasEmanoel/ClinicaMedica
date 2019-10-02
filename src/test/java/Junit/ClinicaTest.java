package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import model.dao.ClinicaDao;
import model.entidades.Clinica;

public class ClinicaTest {

	private ClinicaDao cd;
	private Clinica clinica;
	private Clinica consulta;
	
	@Before
	public void inicializa() {
		this.cd = new ClinicaDao();
		this.clinica = new Clinica();
		this.consulta = new Clinica();
		
		clinica.setCnpj("123");
		clinica.setEmail("clinica@gmail.com");
		clinica.getEndereco().setBairro("1");
		clinica.getEndereco().setCep("1");
		clinica.getEndereco().setRua("1");
		clinica.setNome("clinica");
		clinica.setSenha("1");
		clinica.setIdade(30);
		clinica.setTelefone1("1");
		clinica.setTelefone2("1");
		clinica.getPerfil().setDescricao("clinica");
	}

	@Test
	public void registerClinicaTest() throws Exception {

		cd.salvar(clinica);

		consulta = cd.encontrarPorCnpj("123");
		assertEquals(consulta.getCnpj(), "123");

	}	
	
	@Test
	public void updateClinicaTest() {
		consulta = cd.encontrarPorCnpj("123");
		consulta.setNome("Clinica Atualizado");
		cd.atualizar(consulta);
		
		assertEquals(consulta.getNome(), "Clinica Atualizado");
	}
	
	@Test
	public void deleteClinicaTest() {
		consulta = cd.encontrarPorCnpj("123");
		
		cd.deletar(consulta);
		
		assertNull(consulta);
	}
}
