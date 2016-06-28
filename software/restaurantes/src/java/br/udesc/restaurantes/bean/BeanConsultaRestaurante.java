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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

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

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Query query = em.createQuery("select r from Restaurante r where r.nomeEstabelecimento = :nome");
        query.setParameter("nome", mbean.getPesquisa());
        try {
            restaurante = (Restaurante) query.getSingleResult();
        } catch (Exception e) {
            restaurante = null;
        }
        em.close();
        emf.close();
        mbean.setPesquisa("");

    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
