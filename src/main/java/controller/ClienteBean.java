package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FlowEvent;

import model.dao.PessoaDao;
import model.entidades.Pessoa;

@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Pessoa user;    
    private boolean skip;
    
    public ClienteBean() {
    	this.user = new Pessoa();
    }
    
    public Pessoa getUser() {
        return user;
    }
 
    public void setUser(Pessoa user) {
        this.user = user;
    }
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    public void save() {
    	PessoaDao pd = new PessoaDao();
    	pd.salvar(this.user);
        FacesMessage msg = new FacesMessage("Cadastro feito", "Bem-Vindo :" + user.getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
        
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}