package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import model.dao.ClinicaDao;
import model.entidades.Clinica;
import model.entidades.Endereco;
import model.entidades.Perfil;

public class ClinicaTest {

	private ClinicaDao cd;
	private Clinica clinica;
	private Clinica consulta;
	
	@Before
	public void inicializa() {
		this.cd = new ClinicaDao();
		this.clinica = new Clinica();
		
		this.clinica.setId(1L);
		this.clinica.setCnpj("123456789");
		this.clinica.setEmail("clinica@gmail.com");
		this.clinica.setEndereco(new Endereco());
		this.clinica.setId(1L);
		this.clinica.getEndereco().setBairro("123");
		this.clinica.getEndereco().setCep("123");
		this.clinica.getEndereco().setRua("123");
		this.clinica.setIdade(20);
		this.clinica.setNome("clinica");
		this.clinica.setSenha("12345678");
		this.clinica.setTelefone1("987654321");
		this.clinica.setTelefone2("123456789");
		this.clinica.setPerfil(new Perfil());
		this.clinica.getPerfil().setId(1L);
		this.clinica.getPerfil().setDescricao("clinica");
	}

	@Test
	public void registerClinicaTest() throws Exception {

		cd.salvar(this.clinica);

		consulta = cd.encontrarPorCnpj("123456789");
		assertEquals(consulta, this.clinica);

	}

	@Test
	public void editClinicaTest() throws Exception {
		this.clinica.setNome("clinica Atualizada");
		
		cd.atualizar(this.clinica);
		consulta = cd.encontrarPorCnpj("123456789");
		assertEquals(consulta, this.clinica);
	}
			
	@Test
	public void deleteClinicaTest() throws Exception {
				
		cd.deletar(this.clinica);
		
		consulta = cd.encontrarPorCnpj("123456789");
		
		assertNull(consulta);
	}
}
