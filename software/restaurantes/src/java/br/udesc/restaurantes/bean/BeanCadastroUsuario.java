package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.dao.core.JPAFactory;
import br.udesc.restaurantes.modelo.dao.core.UsuarioDAO;
import br.udesc.restaurantes.modelo.entidade.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@ViewScoped
public class BeanCadastroUsuario {

    private Usuario usuario;
    private UsuarioDAO dao;

    public BeanCadastroUsuario() {
        usuario = new Usuario();
        dao = JPAFactory.getUsuarioDAO();
    }

    public String salvar() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
            em.close();
            emf.close();
        } catch (Exception ex) {
        }
        return "index";
    }

    public String apelido() {
        if (dao.apelido(usuario.getApelido()) == null) {
            return salvar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Apelido ja existe"));
            return null;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }

}
