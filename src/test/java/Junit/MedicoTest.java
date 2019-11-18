package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.ClinicaDao;
import model.dao.MedicoDao;
import model.entidades.Clinica;
import model.entidades.Medico;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MedicoTest {
	
	
	private ClinicaDao cd;
	private MedicoDao md;
	private Medico medico;
	
	
	@Before
	public void inicializa() {
		this.md = new MedicoDao();
		this.cd = new ClinicaDao();
			
	}

	@Test
	public void _1registerMedicoTest() throws Exception {
		
		Clinica clinica = cd.encontrarPorCnpj("123");
		
		this.medico = new Medico();
		this.medico.setCpf("3");
		this.medico.setCrm(3L);
		this.medico.setEmail("medico@gmail.com");
		this.medico.getEndereco().setBairro("3");
		this.medico.getEndereco().setCep("3");
		this.medico.getEndereco().setRua("3");
		this.medico.setClinica(clinica);
		this.medico.setIdade(45);
		this.medico.setMeta(3);
		this.medico.setNome("medico");
		this.medico.getPerfil().setDescricao("medico");
		this.medico.setRg("3");
		this.medico.setSalario(10.000);
		this.medico.setSenha("3");
		this.medico.setTelefone1("3");
		this.medico.setTelefone2("3");
		Medico resultado = md.salvar(this.medico);


		assertEquals(resultado, this.medico);
	}
	
	@Test
	public void _2updateMedicoTest() {
		
		this.medico = md.encontrarPorCpf("3");
		this.medico.setNome("Medico Atualizado");
		
		Medico resultado = md.atualizar(this.medico);
		
		assertEquals(resultado, this.medico);
	}
	
	
	@Test
	public void _3deleteMedicoTest() {
		this.medico = md.encontrarPorCpf("3");
		
		boolean resultado = md.deletar(this.medico);
		
		assertTrue(resultado);
	}
}
