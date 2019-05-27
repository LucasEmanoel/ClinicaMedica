package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.dao.PessoaDao;
import model.entidades.Pessoa;

@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter {
    
    private PessoaDao dao = new PessoaDao();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Pessoa med;
        med = null;
        try{
            Long idMedico = Long.parseLong(string);
            med = this.dao.encontrar(Pessoa.class, idMedico);
            
        }
        catch(Exception e){
            System.out.println(e.getClass() + "   " +e.getMessage());
                
        }
        return med;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Pessoa medico = (Pessoa) o;
        return medico.getId()+ "";
    }
}
