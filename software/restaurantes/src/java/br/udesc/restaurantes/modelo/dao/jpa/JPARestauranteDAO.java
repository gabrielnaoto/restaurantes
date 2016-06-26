package br.udesc.restaurantes.modelo.dao.jpa;

import br.udesc.restaurantes.modelo.dao.core.RestauranteDAO;
import br.udesc.restaurantes.modelo.entidade.Restaurante;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

public class JPARestauranteDAO implements Serializable, RestauranteDAO {

     EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void salvar(Restaurante restaurante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(restaurante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void excluir(Restaurante restaurante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            restaurante = em.merge(restaurante);
            em.remove(restaurante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public Restaurante pesquisar(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Restaurante.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Restaurante> listar() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query consulta = em.createQuery("select r from Restaurante r");
            return consulta.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
