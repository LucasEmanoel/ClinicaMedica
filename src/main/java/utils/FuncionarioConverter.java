package utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.dao.PessoaDao;
import model.entidades.Funcionario;
import model.entidades.Pessoa;

@FacesConverter("funcionarioConverter")
public class FuncionarioConverter implements Converter {
    
    private PessoaDao dao = new PessoaDao();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) 
    {
        Funcionario funcionario;
        funcionario = null;
    
        try{
            Long idMedico = Long.parseLong(string);
            funcionario = (Funcionario) this.dao.encontrar(Pessoa.class, idMedico);
        }
        catch(Exception e){
            System.out.println(e.getClass() + "   " +e.getMessage());
                
        }
        return funcionario;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) 
    {
    	Funcionario funcionario = (Funcionario) o;
        return funcionario.getId()+ "";
    }
}
