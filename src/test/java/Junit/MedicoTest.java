package Junit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.dao.ClinicaDao;
import model.dao.MedicoDao;
import model.entidades.Clinica;
import model.entidades.Endereco;
import model.entidades.Medico;
import model.entidades.Perfil;

public class MedicoTest {

	private MedicoDao md;
	private Medico medico;
	private Medico consulta;
	private ClinicaDao cd;
	private Clinica clinica;
	
	@Before
	public void inicializa() {
		this.md = new MedicoDao();
		this.medico = new Medico();
		this.cd = new ClinicaDao();
		
		this.medico.setCpf("123456");
		this.medico.setId(3L);
		this.medico.setCrm(123456L);	
		this.medico.setEmail("medico@gmail.com");
		this.medico.setEndereco(new Endereco());
		this.medico.getEndereco().setId(3L);
		this.medico.getEndereco().setBairro("123");
		this.medico.getEndereco().setCep("123");
		this.medico.getEndereco().setRua("123");
		this.medico.setIdade(45);
		this.medico.setMeta(10);
		this.medico.setNome("medico");
		this.medico.setPerfil(new Perfil());
		this.medico.getPerfil().setId(3L);
		this.medico.getPerfil().setDescricao("perfil Medico");
		this.medico.setRg("123");
		this.medico.setSalario(10.000);
		this.medico.setSenha("senha123");
		this.medico.setTelefone1("123456789");
		this.medico.setTelefone2("123456789");
	}

	@Test
	public void registerMedicoTest() throws Exception {
		this.clinica = cd.encontrarPorCnpj("123456789");
		this.medico.setClinica(this.clinica);
		md.salvar(this.medico);

		this.consulta = md.encontrarPorCpf("123456");

		assertEquals(consulta, this.medico);
	}

	@Test
	public void editMedicoTest() throws Exception {
		this.medico.setNome("medico atualizado");

		md.atualizar(this.medico);
		this.consulta = md.encontrarPorCpf("123456");

		assertEquals(consulta, this.medico);
	}

	@Test
	public void deleteClinicaTest() throws Exception {
		md.deletar(this.medico);
		this.consulta = md.encontrarPorCpf("123456");

		assertEquals(consulta, this.medico);
	}

}
