/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.dao.core.util.SessionUtils;
import br.udesc.restaurantes.modelo.entidade.Usuario;
import java.awt.event.ActionEvent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@ViewScoped
public class BeanLogin {

    private Usuario usuario;
    private String username;
    private String password;

    public void login() {
        boolean loggedIn = false;         
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
                    usuario = new Usuario("Marcelo", null, null, null, null, null, null, 0);
                    SessionUtils.setParam("user", usuario);
                    loggedIn = true;
        } else {
            loggedIn = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Apelido já existe"));
        }                
    }
    
    public String logout(){
        SessionUtils.invalidate();
        return "index.jsf";
    }
    
    public BeanLogin() {
        usuario = (Usuario) SessionUtils.getParam("user");
        username = "";
        password = "";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
