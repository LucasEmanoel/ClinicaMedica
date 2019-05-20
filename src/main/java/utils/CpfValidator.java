package utils;

import java.util.InputMismatchException;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class CpfValidator implements Validator {
	
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valorTela)
			throws ValidatorException {
		
		valorTela = remove(String.valueOf(valorTela));
		
		if( validaCPF(String.valueOf(valorTela)) != true){
			FacesMessage message = new FacesMessage();
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			message.setSummary("CPF INV�LIDO");
		
			throw new ValidatorException(message);
		}
	}
	
	private static boolean validaCPF(String CPF){
		
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
	        CPF.equals("22222222222") || CPF.equals("33333333333") ||
	        CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") ||
	        CPF.equals("88888888888") || CPF.equals("99999999999") ||
	        CPF.length() != 11 || CPF.length() == 14 ){
	   
	    	return(false);
	    }else{
	    
		    char dig10, dig11;
		    int sm, i, r, num, peso;
		 
		    try {
		      sm = 0;
		      peso = 10;
		      for (i=0; i<9; i++) {             
		        num = (int)(CPF.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		 
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig10 = '0';
		      else dig10 = (char)(r + 48); 
		 
		      sm = 0;
		      peso = 11;
		      for(i=0; i<10; i++) {
		        num = (int)(CPF.charAt(i) - 48);
		        sm = sm + (num * peso);
		        peso = peso - 1;
		      }
		 
		      r = 11 - (sm % 11);
		      if ((r == 10) || (r == 11))
		         dig11 = '0';
		      else dig11 = (char)(r + 48);
		 
		      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))){
		         return true;
		      } 
		      else {
		    	  return(false);
		      } 
	    } catch (InputMismatchException erro) {
	        return(false);
	    }
	    }
	}
	public static String remove(String CPF){
		  CPF = CPF.replace(".", "");
		  CPF = CPF.replace("-", "");
		
		  return CPF;
	  }
	
}
