package view;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.AmbulatorioModel;
import model.ClienteModel;
import model.ClinicaModel;
import model.ConsultaModel;
import model.EspecialidadeModel;
import model.MedicamentoModel;
import model.MedicoModel;
import model.PagamentoModel;
import model.SecretariaModel;
import model.dao.DaoImpl;
import model.entidades.Ambulatorio;
import model.entidades.Cliente;
import model.entidades.Clinica;
import model.entidades.Consulta;
import model.entidades.Endereco;
import model.entidades.Especialidade;
import model.entidades.Medicamento;
import model.entidades.Medico;
import model.entidades.Pagamento;
import model.entidades.Secretaria;

public class teste {

	public static void main(String[] args) throws Exception {
		Endereco endeCliente = new Endereco("sei la", "centro", "251515");
//		
//		Cliente c = new Cliente("Lucas", "cpf1", "rg1", 15, "telefone1", endeCliente, "email1", "senha1");		
//		testeCliente(c);

		Clinica clinica = new Clinica("email2", "senha2", "cnpj1", "telefone2", endeCliente);
//		
		Medico medico = new Medico("Dr. joao", "cpf2", "rg2", 50, "telefone3", endeCliente, "email3", 30000.0,
				"senha3", clinica, 1575L, 10);
		testeMedico(medico);
//		
//		Secretaria secretaria = new Secretaria("maria", "cpf3", "r3",25 , "telefone3", endeCliente, "email4", "senha4", 5000.0, 51651L, clinica, "qualificacao1");
//		testeSecretaria(secretaria);
//		
//		Ambulatorio ambulatorio = new Ambulatorio(10, 2);
//		testeAmbulatorio(ambulatorio);
//		
//		Medicamento medicamento = new Medicamento(15351L, "para dor de cabeça");
//		testeMedicamento(medicamento);
//		
//		Pagamento pagamento = new Pagamento(151.0);
//		testePagamento(pagamento);
//		
//		Consulta consulta = new Consulta("dengue", new Date(15101999L), new Time(15L));
//		testeConsulta(consulta);
//		
		List<Medico> meds = new ArrayList<Medico>();
		meds.add(medico);
		Especialidade especialidade = new Especialidade("tratador de Rin", 26153L);
		especialidade.setMedico(meds);
		testeEspecilidade(especialidade);

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

	public static void testeConsulta(Consulta con) {

		ConsultaModel cm = new ConsultaModel();

		try {
			cm.registrarConsulta(con);
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

	public static void testePagamento(Pagamento pag) {
		PagamentoModel pm = new PagamentoModel();

		try {
			pm.registrarPagamento(pag);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}