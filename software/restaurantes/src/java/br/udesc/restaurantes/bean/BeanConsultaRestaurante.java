package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.dao.core.AvaliacaoDAO;
import br.udesc.restaurantes.modelo.dao.core.ComentarioDAO;
import br.udesc.restaurantes.modelo.dao.core.JPAFactory;
import br.udesc.restaurantes.modelo.dao.core.RestauranteDAO;
import br.udesc.restaurantes.modelo.dao.core.UsuarioDAO;
import br.udesc.restaurantes.modelo.dao.core.util.SessionUtil;
import br.udesc.restaurantes.modelo.entidade.Avaliacao;
import br.udesc.restaurantes.modelo.entidade.Comentario;
import br.udesc.restaurantes.modelo.entidade.Restaurante;
import br.udesc.restaurantes.modelo.entidade.Usuario;
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
    private Usuario usuario;
    private RestauranteDAO rdao;
    private UsuarioDAO udao;
    private AvaliacaoDAO adao;
    private ComentarioDAO cdao;

    private Comentario comentario;
    private Avaliacao avaliacao;

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
        udao = JPAFactory.getUsuarioDAO();
        avaliacao = new Avaliacao();
        comentario = new Comentario();
        cdao = JPAFactory.getComentarioDAO();
        adao = JPAFactory.getAvaliacaoDAO();
        String r = null;
        FacesContext ctx = FacesContext.getCurrentInstance();
        Map sessionMap = ctx.getExternalContext().getSessionMap();
        BeanPesquisa mbean = (BeanPesquisa) sessionMap.get("beanPesquisa");
        rdao = JPAFactory.getRestauranteDAO();
        r = mbean.getPesquisa();
        restaurante = rdao.consultar(r);
        mbean.setPesquisa("");
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void addComentario() {
        avaliacao.setComentario(comentario);
        avaliacao.setRestaurante(restaurante);
        Usuario u = (Usuario) SessionUtil.getParam("user");
        avaliacao.setUsuario(u);
//        if (avaliacao.getUsuario() == u){
//            adao.excluir(avaliacao);
//        }

        adao.salvar(avaliacao);
        restaurante.addAvaliacao(avaliacao);

        avaliacao = new Avaliacao();
        comentario = new Comentario();
    }

}
