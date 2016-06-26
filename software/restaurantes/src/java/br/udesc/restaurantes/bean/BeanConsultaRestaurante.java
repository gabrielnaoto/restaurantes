/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.entidade.Categoria;
import br.udesc.restaurantes.modelo.entidade.Restaurante;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ignoi
 */
@ManagedBean
@ViewScoped
public class BeanConsultaRestaurante {

    private Restaurante restaurante;

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 3; i++) {
            images.add(i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }

    public BeanConsultaRestaurante() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map sessionMap = ctx.getExternalContext().getSessionMap();
        BeanPesquisa mbean = (BeanPesquisa) sessionMap.get("beanPesquisa");
        if (mbean.getPesquisa().equalsIgnoreCase("madalosso")) {
            restaurante = new Restaurante("Desde 1963 o Madalosso constrói sua história como um restaurante familiar, que encontrou na tradição italiana um estilo único de servir e degustar. O restaurante mantém até hoje suas origens, cuidando de cada cliente como um convidado, um velho amigo da casa. Conheça nossa trajetória.", "Madalosso", new Categoria("Italiano"));
            restaurante.setAvaliacao(4);
        } else {
            restaurante = null;
        }
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
