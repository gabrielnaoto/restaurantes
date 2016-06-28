package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.dao.core.JPAFactory;
import br.udesc.restaurantes.modelo.dao.core.RestauranteDAO;
import br.udesc.restaurantes.modelo.entidade.Restaurante;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class BeanConsultaRestaurante {

    private Restaurante restaurante;
    private RestauranteDAO dao;

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
        String r = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map sessionMap = ctx.getExternalContext().getSessionMap();
        BeanPesquisa mbean = (BeanPesquisa) sessionMap.get("beanPesquisa");
        dao = JPAFactory.getRestauranteDAO();
        r = mbean.getPesquisa();
        restaurante = dao.consultar(r);
        mbean.setPesquisa("");
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

}
