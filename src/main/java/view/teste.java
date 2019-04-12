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
		Endereco endeCliente = new Endereco("sei la", "centro", "251515");
		Cliente c = new Cliente("Lucas", "dsafasg", "15416faf", 15, "42153", endeCliente, "aldsahujas", "fkjashsajfk");		
		testeCliente(c);
		
//		Clinica clinica = new Clinica("ClinicaBoa@gmail", "215635.020", "1575-48148", endeCliente);
//		
//		Medico medico = new Medico("Dr. joao", "261361", "2651", 50, "15153-151", endeCliente, "clinicaJoao@", 30000.0, "nothing", clinica, 1575L, 10);
//		testeMedico(medico);
//		
//		Secretaria secretaria = new Secretaria("maria", "1553", "153843",25 , "15748-48", endeCliente, "maria@", "1597", 5000.0, 51651L, clinica, "faaztudo");
//		testeSecretaria(secretaria);
//		
	}

	public static void testeEndereco(Endereco endereco) {

		DaoImpl<Endereco> DaoEn = new DaoImpl<Endereco>();
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