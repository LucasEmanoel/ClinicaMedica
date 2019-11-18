package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.ClinicaDao;
import model.dao.SecretariaDao;
import model.entidades.Clinica;
import model.entidades.Secretaria;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SecretariaTest {
	
	private ClinicaDao cd;
	private SecretariaDao sd;
	private Secretaria secretaria;
	
	@Before
	public void inicializa() {
		this.cd = new ClinicaDao();
		this.sd = new SecretariaDao();
	}

	@Test
	public void _1registerSecretariaTest() throws Exception {
		
		Clinica clinica = cd.encontrarPorCnpj("123");
		
		this.secretaria = new Secretaria();
		this.secretaria.setCpf("4");
		this.secretaria.setQualificacao("varias");
		this.secretaria.setClinica(clinica);
		this.secretaria.setEmail("secretaria@gmail.com");
		this.secretaria.getEndereco().setBairro("4");
		this.secretaria.getEndereco().setCep("4");
		this.secretaria.getEndereco().setRua("4");
		this.secretaria.setIdade(45);
		this.secretaria.setNome("secretaria");
		this.secretaria.getPerfil().setDescricao("secretaria");
		this.secretaria.setRg("4");
		this.secretaria.setSalario(5.000);
		this.secretaria.setSenha("4");
		this.secretaria.setTelefone1("4");
		this.secretaria.setTelefone2("4");
		
		Secretaria resultado = sd.salvar(this.secretaria);


		assertEquals(resultado, this.secretaria);
	}
	
	@Test
	public void _2updateSecretariaTest() {
		
		this.secretaria = sd.encontrarPorCpf("4");
		this.secretaria.setNome("Secretaria Atualizado");
		
		Secretaria resultado = sd.atualizar(this.secretaria);
		
		assertEquals(resultado, this.secretaria);
	}
	
	@Test
	public void _3deleteSecretariaTest() {
		this.secretaria = sd.encontrarPorCpf("4");
		
		boolean resultado = sd.deletar(this.secretaria);
		
		assertNull(resultado);
	}
}
