package Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.UsuarioModel;
import model.dao.ClienteDao;
import model.dao.ClinicaDao;
import model.dao.MedicoDao;
import model.dao.SecretariaDao;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Medico;
import model.entidades.Secretaria;
import model.exceptions.ClinicaMedicaException;

public class LoginTest {

	private UsuarioModel um;
	private ClienteDao cd;
	private MedicoDao md;
	private ClinicaDao clid;
	private SecretariaDao sd;


	@Before
	public void inicializa() {
		um = new UsuarioModel();
		cd = new ClienteDao();
		md = new MedicoDao();
		clid = new ClinicaDao();
		sd = new SecretariaDao();
	}
	
	
	@Test(expected = ClinicaMedicaException.class)
	public void logarErradoCamposVazios() throws ClinicaMedicaException {
		String email = null;
		String senha = null;
		
		Object user = um.logar(email, senha);
		
	}
	
	@Test
	public void logarErrado() throws ClinicaMedicaException {
		String email = "errado@gmail.com";
		String senha = "errado";
		
		Object user = um.logar(email, senha);
		
		assertEquals("Email ou Senha inválidos!!", user);
	}
	
	@Test
	public void LogarClientTest() throws ClinicaMedicaException {
		String email = "cliente@gmail.com";
		String senha = "2";

		Object user = um.logar(email, senha);
		Cliente consulta = cd.encontrarPorEmail(email);
		
		
		assertEquals(consulta, user);
	}
	
	@Test
	public void LogarMedicoTest() throws ClinicaMedicaException {
		String email = "medico@gmail.com";
		String senha = "3";

		Object user = um.logar(email, senha);
		Medico consulta = md.encontrarPorEmail(email);

		assertEquals(consulta, user);
	}
	
	@Test
	public void LogarSecretariaTest() throws ClinicaMedicaException {
		String email = "secretaria@gmail.com";
		String senha = "4";

		Object user = um.logar(email, senha);

		Secretaria consulta = sd.encontrarPorEmail(email);
		
		assertEquals(consulta, user);
	}
	
	@Test
	public void LogarClinicaTest() throws ClinicaMedicaException {
		String email = "clinica@gmail.com";
		String senha = "1";

		Object user = um.logar(email, senha);
		
		Clinica consulta = clid.encontrarPorEmail(email);
		
		assertEquals(consulta, user);
	}
}
