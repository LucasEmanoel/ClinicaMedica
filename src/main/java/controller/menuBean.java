package controller;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;

import model.entidades.Pessoa;

@ManagedBean
@ViewScoped
public class menuBean {

    private DefaultMenuModel menuModel;
    
    public menuBean() {
        this.menuModel = this.retornaMenu();
    }

    public DefaultMenuModel retornaMenu() {
        DefaultMenuModel menuModel = new DefaultMenuModel();
        
        DefaultSubMenu subMenu = new DefaultSubMenu();
        subMenu.setLabel("Históricos");
        DefaultMenuItem item = new DefaultMenuItem();
        
    
        Pessoa user = (Pessoa) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("perfil");
        String tipoPerfil = user.getPerfil().getDescricao();
        
        if (tipoPerfil.equals("medico")) {
        	
            item = new DefaultMenuItem();
            item.setValue("Atender");
            item.setId("link-atender");
            item.setUrl("AtendimentoView.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Meus Atendimentos");
            item.setId("link-atendimentos");
            item.setUrl("HistoricoView.xhtml");
            subMenu.addElement(item);
            
            
            item = new DefaultMenuItem();
            item.setValue("Todos Históricos");
            item.setId("link-historicos");
            item.setUrl("HistoricoView.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setId("link-perfil");
            item.setUrl("PerfilMedicoView.xhtml");
            
            menuModel.addElement(item);

            menuModel.generateUniqueIds();

            return menuModel;
            
        } else if(tipoPerfil.equals("secretaria")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Gerenciar Agendamentos");
            item.setId("link-agendamentos");
            item.setUrl("#");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Todos Históricos");
            item.setId("link-historicos");
            item.setUrl("HistoricoView.xhtml");

            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setId("link-perfil");
            item.setUrl("PerfilSecretariaView.xhtml");
            
            menuModel.addElement(item);

            menuModel.generateUniqueIds();

            return menuModel;
        } else if(tipoPerfil.equals("clinica")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Gerenciar Funcionarios");
            item.setId("link-funcionarios");
            item.setUrl("GerenciarFuncionarios.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setId("link-perfil");
            item.setUrl("PerfilClinicaView.xhtml");
            
            menuModel.addElement(item);
            menuModel.generateUniqueIds();

            return menuModel;
        } else if(tipoPerfil.equals("cliente")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Marcar Consulta");
            item.setId("link-marcar");
            item.setUrl("ConsultaView.xhtml");
            
            menuModel.addElement(item);
            
            
            item = new DefaultMenuItem();
            item.setValue("Visulizar Históricos");
            item.setId("link-historicos");
            item.setUrl("HistoricoView.xhtml");
            menuModel.addElement(item);

            
        	item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setId("link-perfil");
            item.setUrl("PerfilClienteView.xhtml");
            
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