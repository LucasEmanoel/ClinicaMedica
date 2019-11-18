package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.dao.PessoaDao;
import model.entidades.Medico;
import model.entidades.Pessoa;

@FacesConverter("medicoConverter")
public class MedicoConverter implements Converter{
	
	private PessoaDao dao = new PessoaDao();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) 
    {
        Medico medico;
        medico = null;
    
        try{
            Long idMedico = Long.parseLong(string);
            medico = (Medico) this.dao.encontrar(Pessoa.class, idMedico);
        }
        catch(Exception e){
            System.out.println(e.getClass() + "   " +e.getMessage());
                
        }
        return medico;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) 
    {
    	Medico medico = (Medico) o;
        return medico.getId()+ "";
    }
}
