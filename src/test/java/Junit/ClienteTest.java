package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.dao.AmbulatorioDao;
import model.dao.ClienteDao;
import model.dao.ConsultaDao;
import model.dao.MedicoDao;
import model.entidades.Ambulatorio;
import model.entidades.Cliente;
import model.entidades.Consulta;
import model.entidades.Medico;

public class ClienteTest {

	private ClienteDao cd;
	private Cliente cli;
	private Cliente consulta;
	private ConsultaDao con;
	private Consulta consultaMedica;

	@Before
	public void inicializa() {
		this.cd = new ClienteDao();
		this.consulta = new Cliente();
		this.cli = new Cliente();
		this.con = new ConsultaDao();
		this.consultaMedica = new Consulta();

		cli.setCpf("2");
		cli.setEmail("cliente@gmail.com");
		cli.getEndereco().setBairro("2");
		cli.getEndereco().setCep("2");
		cli.getEndereco().setRua("2");
		cli.setIdade(25);
		cli.setNome("Jeremy");
		cli.getPerfil().setDescricao("perfil Cliente");
		cli.setRg("2");
		cli.setSenha("2");
		cli.setTelefone1("2");
		cli.setTelefone2("2");
	}

	@Test
	public void registerClientTest() {

		cd.salvar(this.cli);

		consulta = cd.encontrarPorCpf("2");

		assertEquals(consulta.getCpf(), "2");
	}
	
	@Test
	public void updateClientTest() {
		consulta = cd.encontrarPorCpf("2");
		consulta.setNome("Cliente Atualizado");
		cd.atualizar(consulta);
		
		assertEquals(consulta.getNome(), "Cliente Atualizado");
	}
	
	@Test
	public void realizarConsultaTest() throws ParseException {
		ClienteDao cm = new ClienteDao();
		MedicoDao md = new MedicoDao();
		AmbulatorioDao ambud = new AmbulatorioDao();
		Ambulatorio ambu = new Ambulatorio();
		Consulta busca = new Consulta();
		
		Cliente cli = cm.encontrarPorCpf("2");
		Medico med = md.encontrarPorCpf("3");
		ambu = ambud.encontrarByNumero(2);
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("2020-10-15");
			
		
		consultaMedica.setAmbulatorio(ambu);
		consultaMedica.setCliente(cli);
		consultaMedica.setData(date);
		consultaMedica.setDescricao("consulta de coracao");
		consultaMedica.setMedico(med);
		consultaMedica.getPagamento().setValor(150.00);

		con.salvar(consultaMedica);
		
		busca = con.findConsultaPorPagamentoId(1L);
		assertEquals(busca.getCliente().getCpf(), consultaMedica.getCliente().getCpf());

	}
	
	@Test
	public void deleteClientTest() {
		consulta = cd.encontrarPorCpf("2");
		
		cd.deletar(consulta);
		
		assertNull(consulta);
	}

}
