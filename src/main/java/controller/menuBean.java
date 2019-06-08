package controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;

import model.entidades.Pessoa;

@ManagedBean
@SessionScoped
public class menuBean {

    private DefaultMenuModel menuModel;

    public menuBean() {
        this.menuModel = this.retornaMenu();
    }

    public DefaultMenuModel retornaMenu() {
        DefaultMenuModel menuModel = new DefaultMenuModel();

        DefaultMenuItem item = new DefaultMenuItem();
        item.setValue("Página 1");
        item.setUrl("pagina1.xhtml");
       
    
        Pessoa user = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil");
        String tipoPerfil = user.getPerfil().getDescricao();
        
        if (tipoPerfil.equals("medico")) {
        	
            item = new DefaultMenuItem();
            item.setValue("Atender");
            item.setUrl("AtendimentoView.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Visulizar Históricos");
            item.setUrl("HistoricoView.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setUrl("#");
            
            menuModel.addElement(item);

            menuModel.generateUniqueIds();

            return menuModel;
            
        } else if(tipoPerfil.equals("secretaria")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Gerenciar Agendamentos");
            item.setUrl("#");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Visulizar Históricos");
            item.setUrl("HistoricoView.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setUrl("#");
            
            menuModel.addElement(item);

            menuModel.generateUniqueIds();

            return menuModel;
        } else if(tipoPerfil.equals("clinica")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Gerenciar Funcionarios");
            item.setUrl("PF('funcionarios').show(); return false;");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setUrl("#");
            
            menuModel.addElement(item);
            menuModel.generateUniqueIds();

            return menuModel;
        } else if(tipoPerfil.equals("cliente")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Marcar Consulta");
            item.setUrl("PF('marcar').show(); return false;");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Visulizar Históricos");
            item.setUrl("HistoricoView.xhtml");
            
            menuModel.addElement(item);
            
        	item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setUrl("#");
            
            menuModel.addElement(item);
            menuModel.generateUniqueIds();

            return menuModel;
        }
		return null;
    }

    public DefaultMenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(DefaultMenuModel menuModel) {
        this.menuModel = menuModel;
    }
}