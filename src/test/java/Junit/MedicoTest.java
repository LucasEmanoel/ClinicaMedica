package Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.dao.ClinicaDao;
import model.dao.MedicoDao;
import model.entidades.Clinica;
import model.entidades.Medico;

public class MedicoTest {
	
	private ClinicaDao cd;
	private Clinica clinica;
	private MedicoDao md;
	private Medico medico;
	private Medico consulta;
	
	
	@Before
	public void inicializa() {
		this.md = new MedicoDao();
		this.medico = new Medico();
		this.consulta = new Medico();
		this.cd = new ClinicaDao();
		this.clinica = new Clinica();
		
		clinica = cd.encontrarPorCnpj("123");
		
		medico.setCpf("3");
		medico.setCrm(3L);
		medico.setEmail("medico@gmail.com");
		medico.getEndereco().setBairro("3");
		medico.getEndereco().setCep("3");
		medico.getEndereco().setRua("3");
		medico.setClinica(clinica);
		medico.setIdade(45);
		medico.setMeta(3);
		medico.setNome("medico");
		medico.getPerfil().setDescricao("perfil Medico");
		medico.setRg("3");
		medico.setSalario(10.000);
		medico.setSenha("3");
		medico.setTelefone1("3");
		medico.setTelefone2("3");
	}

	@Test
	public void registerMedicoTest() throws Exception {
		
		md.salvar(this.medico);

		consulta = md.encontrarPorCpf("3");

		assertEquals(consulta.getCpf(), "3");
	}
}
