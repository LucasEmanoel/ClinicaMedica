package view;

import model.AmbulatorioModel;
import model.ClienteModel;
import model.ClinicaModel;
import model.ConsultaModel;
import model.EncaminhamentoModel;
import model.EspecialidadeModel;
import model.MedicamentoModel;
import model.MedicoModel;
import model.PagamentoModel;
import model.ProntuarioModel;
import model.SecretariaModel;
import model.dao.DaoImpl;
import model.entidades.Ambulatorio;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Consulta;
import model.entidades.Encaminhamento;
import model.entidades.Endereco;
import model.entidades.Especialidade;
import model.entidades.Medicamento;
import model.entidades.Medico;
import model.entidades.Pagamento;
import model.entidades.Prontuario;
import model.entidades.Secretaria;

public class teste {

	public static void main(String[] args) throws Exception {
		Endereco endeMedico = new Endereco("rua dos rico", "centro", "251515");
		Endereco endeClinica = new Endereco("tatu", "dsads", "5151");
		Endereco endeCliente = new Endereco("sei la", "centro", "251515");
		Endereco endeSecretaria = new Endereco("subSolo", "centro", "251515");
		
		Clinica clinica = new Clinica("WEb@gmail", "dsasd", "ddsdasdas", endeClinica);
		Medico medico = new Medico("ze do cachao", "dsadsafd", "dfagsd", 89, "dsadsada", endeMedico, "d", 50000.0, "morte",clinica, 841815L, 1000);
		Secretaria secretaria = new Secretaria("joana", "dasfas", "asfaf", 30, "5561", endeSecretaria, "maria", "12515", 5000.0, 15661L, clinica, "faz tudo");
		Cliente cliente = new Cliente("Lucas", "1575", "dsddafas", 19, "41515", endeCliente, "Lucas@gmail", "lucaz","12345");
		
		Ambulatorio ambu = new Ambulatorio(156, 3);
		ambu.setCliente(cliente);
		ambu.setMedico(medico);
		ambu.setSecretaria(secretaria);

		//testeClinica(clinica);
		
		testeSecretaria(secretaria);
		testeCliente(cliente);
		testeMedico(medico);
		
		testeAmbulatorio(ambu);

	}

	public static void testeEndereco(Endereco endereco) {

		DaoImpl<Endereco> DaoEn = new DaoImpl<Endereco>(Endereco.class);
		DaoEn.salvar(endereco);

	}

	public static void testeClinica(Clinica clinica) {

		ClinicaModel cm = new ClinicaModel();

		try {
			cm.registrarClinica(clinica);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeCliente(Cliente cliente) {

		ClienteModel cm = new ClienteModel();

		try {
			cm.registrarCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeSecretaria(Secretaria sec) {

		SecretariaModel sm = new SecretariaModel();

		try {
			sm.registrarSecretaria(sec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeEspecilidade(Especialidade e) {
		
		EspecialidadeModel em = new EspecialidadeModel();
		
		try {
			em.registrarEspecialidade(e);
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
	public static void testeMedico(Medico med) {

		MedicoModel mm = new MedicoModel();

		try {
			mm.registrarMedico(med);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeAmbulatorio(Ambulatorio ambu) {
		
		AmbulatorioModel am = new AmbulatorioModel();

		try {
			am.registrarAmbulatorio(ambu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeConsulta(Consulta con){
		
		ConsultaModel cm = new ConsultaModel();
		
		try {
			cm.registrarConsulta(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testeEncaminhamento(Encaminhamento en) {
		
		EncaminhamentoModel em = new EncaminhamentoModel();
		
		try {
			
			em.registrarEncaminhamento(en);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testeMedicamento(Medicamento m) {
		
		MedicamentoModel mm = new MedicamentoModel();
		 
		 try {
			 
			mm.registrarMedicamento(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testeProntuario(Prontuario pr) {
		ProntuarioModel pm = new ProntuarioModel();
		
		try {
			pm.registrarProntuario(pr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testePagamento(Pagamento pag) {
		PagamentoModel pm = new PagamentoModel();
		
		try {
			pm.registrarPagamento(pag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}