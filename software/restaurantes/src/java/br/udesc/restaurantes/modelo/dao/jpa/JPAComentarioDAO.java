package br.udesc.restaurantes.modelo.dao.jpa;

import br.udesc.restaurantes.modelo.dao.core.ComentarioDAO;
import br.udesc.restaurantes.modelo.entidade.Comentario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

public class JPAComentarioDAO implements Serializable, ComentarioDAO {
 EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void salvar(Comentario comentario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void excluir(Comentario comentario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            comentario = em.merge(comentario);
            em.remove(comentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public Comentario pesquisar(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Comentario.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Comentario> listar() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query consulta = em.createQuery("select c from Comentario c");
            return consulta.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
