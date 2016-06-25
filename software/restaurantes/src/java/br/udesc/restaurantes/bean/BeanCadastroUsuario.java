package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.entidade.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanCadastroUsuario {
    private Usuario usuario;

    public BeanCadastroUsuario() {
        usuario = new Usuario();
    }
    
    public String salvar(){
        return "index";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
