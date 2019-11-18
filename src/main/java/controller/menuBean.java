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
            item.setUrl("AtendimentoView.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Meus Atendimentos");
            item.setUrl("HistoricoView.xhtml");
            subMenu.addElement(item);
            
            
            item = new DefaultMenuItem();
            item.setValue("Todos Históricos");
            item.setUrl("HistoricoView.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setUrl("PerfilMedicoView.xhtml");
            
            menuModel.addElement(item);

            menuModel.generateUniqueIds();

            return menuModel;
            
        } else if(tipoPerfil.equals("secretaria")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Gerenciar Agendamentos");
            item.setUrl("#");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Todos Históricos");
            item.setUrl("HistoricoView.xhtml");

            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setUrl("PerfilSecretariaView.xhtml");
            
            menuModel.addElement(item);

            menuModel.generateUniqueIds();

            return menuModel;
        } else if(tipoPerfil.equals("clinica")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Gerenciar Funcionarios");
            item.setUrl("GerenciarFuncionarios.xhtml");
            
            menuModel.addElement(item);
            
            item = new DefaultMenuItem();
            item.setValue("Perfil");
            item.setUrl("PerfilClinicaView.xhtml");
            
            menuModel.addElement(item);
            menuModel.generateUniqueIds();

            return menuModel;
        } else if(tipoPerfil.equals("cliente")) {
        	
        	item = new DefaultMenuItem();
            item.setValue("Marcar Consulta");
            item.setUrl("ConsultaView.xhtml");
            
            menuModel.addElement(item);
            
            
            item = new DefaultMenuItem();
            item.setValue("Visulizar Históricos");
            item.setUrl("HistoricoView.xhtml");
            menuModel.addElement(item);

            
        	item = new DefaultMenuItem();
            item.setValue("Perfil");
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