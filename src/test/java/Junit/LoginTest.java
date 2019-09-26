package Junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.UsuarioModel;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Medico;
import model.entidades.Secretaria;
import model.exceptions.ClinicaMedicaException;

public class LoginTest {

	private UsuarioModel um = null;
	boolean cliente, medico, clinica, secretaria;

	@Before
	public void inicializa() {
		um = new UsuarioModel();
		medico = clinica = secretaria = cliente = false;
	}
	
	@Test
	public void logarErrado() throws ClinicaMedicaException {
		String email = "errado@gmail.com";
		String senha = "errado";

		Object user = um.logar(email, senha);

		if (user instanceof Cliente || user instanceof Medico ||
				user instanceof Secretaria || user instanceof Clinica) {
			cliente = true;
		}

		assertFalse(cliente);
	}
	@Test
	public void LogarClientTest() throws ClinicaMedicaException {
		String email = "cliente@gmail.com";
		String senha = "2";

		Object user = um.logar(email, senha);

		if (user instanceof Cliente) {
			cliente = true;
		}

		assertTrue(cliente);
	}
	@Test
	public void LogarMedicoTest() throws ClinicaMedicaException {
		String email = "medico@gmail.com";
		String senha = "3";

		Object user = um.logar(email, senha);

		if (user instanceof Medico) {
			cliente = true;
		}

		assertTrue(cliente);
	}
	@Test
	public void LogarSecretariaTest() throws ClinicaMedicaException {
		String email = "secretaria@gmail.com";
		String senha = "4";

		Object user = um.logar(email, senha);

		if (user instanceof Secretaria) {
			cliente = true;
		}

		assertTrue(cliente);
	}
	@Test
	public void LogarClinicaTest() throws ClinicaMedicaException {
		String email = "clinica@gmail.com";
		String senha = "1";

		Object user = um.logar(email, senha);

		if (user instanceof Clinica) {
			cliente = true;
		}

		assertTrue(cliente);
	}
}
