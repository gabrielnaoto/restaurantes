/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.dao.core.JPAFactory;
import br.udesc.restaurantes.modelo.dao.core.UsuarioDAO;
import br.udesc.restaurantes.modelo.dao.core.util.SessionUtil;
import br.udesc.restaurantes.modelo.entidade.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class BeanLogin {

    private Usuario usuario;
    private String username;
    private String password;
    private UsuarioDAO dao;

    public BeanLogin() {
        dao = JPAFactory.getUsuarioDAO();
        if (SessionUtil.getParam("user") == null) {
            System.out.println("é nulo --tagpesquisarrr");
        }
        usuario = (Usuario) SessionUtil.getParam("user");
        username = "";
        password = "";
    }

    public void login() {
        boolean loggedIn = false;
        usuario = dao.autenticar(username, password);
        if (usuario != null) {
            SessionUtil.setParam("user", usuario);
            loggedIn = true;
        } else {
            loggedIn = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário nao cadastrado"));
        }
    }

    public String logout() {
        SessionUtil.invalidate();
        return "index.jsf";
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
