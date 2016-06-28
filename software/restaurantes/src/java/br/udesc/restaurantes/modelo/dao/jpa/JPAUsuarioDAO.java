package br.udesc.restaurantes.modelo.dao.jpa;

import br.udesc.restaurantes.modelo.dao.core.UsuarioDAO;
import br.udesc.restaurantes.modelo.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class JPAUsuarioDAO implements Serializable, UsuarioDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void salvar(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void excluir(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Usuario pesquisar(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Usuario.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public Usuario apelido(String apelido) {
        Usuario u = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByApelido", Usuario.class);
            query.setParameter("ap", apelido);
            u = query.getSingleResult();
        } catch (Exception e) { 
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return u;
    }
    
    @Override
    public Usuario autenticar(String apelido, String senha){
        Usuario u = null;
        EntityManager em = null;
        try {
            em = getEntityManager();
            TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findByLogin", Usuario.class);
            query.setParameter("ap", apelido);
            query.setParameter("senha", senha);
            u = query.getSingleResult();
        } catch (Exception e) { 
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return u;
    }

    @Override
    public List<Usuario> listar() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query consulta = em.createQuery("select u from Usuario u");
            return consulta.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
