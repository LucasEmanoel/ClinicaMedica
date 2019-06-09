package utils;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.dao.ClinicaDao;
import model.entidades.Clinica;

@FacesConverter("clinicaConverter")
public class ClinicaConverter implements Converter {
    
    private ClinicaDao dao = new ClinicaDao();
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) 
    {
    	
        Clinica clinica;
        clinica = null;
        
        try {
        	
            Long idClinica = Long.parseLong(string);
            clinica = this.dao.encontrar(Clinica.class, idClinica);
            
        }
        catch(Exception e){
            System.out.println(e.getClass() + "   " +e.getMessage());
                
        }
        return clinica;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) 
    {
    	Clinica clinica = (Clinica) o;
        return clinica.getId()+ "";
    }
}

