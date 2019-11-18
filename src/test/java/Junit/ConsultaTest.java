package Junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.AmbulatorioDao;
import model.dao.ClienteDao;
import model.dao.ConsultaDao;
import model.dao.MedicoDao;
import model.entidades.Ambulatorio;
import model.entidades.Cliente;
import model.entidades.Consulta;
import model.entidades.Medico;
import model.entidades.Pagamento;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsultaTest {
	
	private ClienteDao cd;
	private MedicoDao md;
	private ConsultaDao con;
	private AmbulatorioDao ambud;
	private List<Consulta> consultas;
	
	@Before
	public void inicializa() {
		this.cd = new ClienteDao();
		this.md = new MedicoDao();
		this.con = new ConsultaDao();
		this.ambud = new AmbulatorioDao();
		
		
	}
	
	@Test
	public void _1realizarConsultaTest() throws ParseException {
		Pagamento pag = new Pagamento();
		pag.setValor(150.00);
		
		Cliente cli = cd.encontrarPorCpf("2");
		Medico med = md.encontrarPorCpf("3");
		Ambulatorio local = ambud.encontrarByNumero(2);
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse("2020-10-15");
			
		Consulta consultaMedica = new Consulta();
		consultaMedica.setAmbulatorio(local);
		consultaMedica.setCliente(cli);
		consultaMedica.setMedico(med);
		consultaMedica.setData(date);
		consultaMedica.setDescricao("consulta de coracao");
		consultaMedica.setPagamento(pag);

		Consulta busca = con.salvar(consultaMedica);
		
		assertEquals(busca, consultaMedica);

	}
	
	@Test
	public void _2atenderPacienteTest() {
		
		Medico medico = md.encontrarPorCpf("3");
		this.consultas = con.findConsultaPorCrmMedico(medico.getCrm());
		
		Consulta consulta = this.consultas.get(0);
		consulta.setStatus(true);
		Consulta resultado = con.atualizar(consulta);
		
		assertEquals(resultado, consulta);
	}
	
	@Test
	public void _2deletarConsultaTest() {
		
		Medico medico = md.encontrarPorCpf("3");
		this.consultas = con.findConsultaPorCrmMedico(medico.getCrm());
		
		Consulta consulta = this.consultas.get(0);
		boolean resultado = con.deletar(consulta);
		
		assertTrue(resultado);
	}
	
}
