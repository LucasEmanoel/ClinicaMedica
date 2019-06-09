package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.dao.PessoaDao;
import model.entidades.Pessoa;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

	private PessoaDao dao = new PessoaDao();

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) 
	{
		Pessoa pessoa;
		pessoa = null;

		try {
			Long idPessoa = Long.parseLong(string);
			pessoa = this.dao.encontrar(Pessoa.class, idPessoa);

		} catch (Exception e) {
			System.out.println(e.getClass() + "   " + e.getMessage());

		}
		
		return pessoa;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object o) 
	{
		Pessoa pessoa = (Pessoa) o;
		return pessoa.getId() + "";
	}
}
