package Junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.dao.AmbulatorioDao;
import model.entidades.Ambulatorio;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AmbulatorioTest {

	private AmbulatorioDao ambuDao;
	private Ambulatorio ambu;
	
	@Before
	public void inicializa() {
		this.ambuDao = new AmbulatorioDao();
		
	}

	@Test
	public void _1registerAmbulatorioTest1() throws Exception {
		
		this.ambu = new Ambulatorio();
		this.ambu.setAndar(2);
		this.ambu.setNumero(2);
		
		Ambulatorio resultado = ambuDao.salvar(this.ambu);
		assertEquals(resultado, this.ambu);

	}	
	
	@Test
	public void _2updateClinicaTest() {
		this.ambu = ambuDao.encontrarByNumero(2);
		this.ambu.setAndar(4);
		
		Ambulatorio resultado = ambuDao.atualizar(this.ambu);
		
		assertEquals(resultado, this.ambu);
	}
	
	@Test
	public void _3deleteClinicaTest() {
		this.ambu = ambuDao.encontrarByNumero(2);
		
		boolean resultado = ambuDao.deletar(this.ambu);
		
		assertTrue(resultado);
	}

}
