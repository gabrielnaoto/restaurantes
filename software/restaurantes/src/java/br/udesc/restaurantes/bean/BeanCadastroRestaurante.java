package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.entidade.Restaurante;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class BeanCadastroRestaurante {
    private Restaurante restaurante;

    public BeanCadastroRestaurante() {
    restaurante = new Restaurante();
    }
    
    public String salvar(){
        return "index";
    }
    
    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
