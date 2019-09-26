package Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.dao.ClinicaDao;
import model.dao.SecretariaDao;
import model.entidades.Clinica;
import model.entidades.Secretaria;

public class SecretariaTest {
	
	private ClinicaDao cd;
	private Clinica clinica;
	private SecretariaDao sd;
	private Secretaria secretaria;
	private Secretaria consulta;
	
	@Before
	public void inicializa() {
		this.cd = new ClinicaDao();
		this.clinica = new Clinica();
		this.sd = new SecretariaDao();
		this.secretaria = new Secretaria();
		this.consulta = new Secretaria();
		
		this.clinica = cd.encontrarPorCnpj("123");
		
		secretaria.setCpf("4");
		secretaria.setQualificacao("varias");
		secretaria.setClinica(clinica);
		secretaria.setEmail("secretaria@gmail.com");
		secretaria.getEndereco().setBairro("4");
		secretaria.getEndereco().setCep("4");
		secretaria.getEndereco().setRua("4");
		secretaria.setIdade(45);
		secretaria.setNome("secretaria");
		secretaria.getPerfil().setDescricao("perfil secretaria");
		secretaria.setRg("4");
		secretaria.setSalario(5.000);
		secretaria.setSenha("4");
		secretaria.setTelefone1("4");
		secretaria.setTelefone2("4");
	}

	@Test
	public void registerSecretariaTest() throws Exception {
		
		sd.salvar(secretaria);

		consulta = sd.encontrarPorCpf("4");

		assertEquals(consulta.getCpf(), "4");
	}
}
