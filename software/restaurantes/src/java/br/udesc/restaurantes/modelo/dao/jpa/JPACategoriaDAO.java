package br.udesc.restaurantes.modelo.dao.jpa;

import br.udesc.restaurantes.modelo.dao.core.CategoriaDAO;
import br.udesc.restaurantes.modelo.entidade.Categoria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

public class JPACategoriaDAO implements Serializable, CategoriaDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void salvar(Categoria categoria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void excluir(Categoria categoria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            categoria = em.merge(categoria);
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public Categoria pesquisar(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Categoria.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Categoria> listar() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query consulta = em.createQuery("select c from Categoria c");
            return consulta.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
