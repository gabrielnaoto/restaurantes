/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.entidade.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ignoi
 */
@ManagedBean
@SessionScoped
public class BeanLogin {

    private Usuario usuario;

    public BeanLogin() {
        usuario = new Usuario("gabriel", null, null, null, null, null, null, 0);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
