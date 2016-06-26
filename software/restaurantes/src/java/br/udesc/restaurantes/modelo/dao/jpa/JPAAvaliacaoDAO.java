package br.udesc.restaurantes.modelo.dao.jpa;

import br.udesc.restaurantes.modelo.dao.core.AvaliacaoDAO;
import br.udesc.restaurantes.modelo.entidade.Avaliacao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;

public class JPAAvaliacaoDAO implements Serializable, AvaliacaoDAO {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void salvar(Avaliacao avaliacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(avaliacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void excluir(Avaliacao avaliacao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            avaliacao = em.merge(avaliacao);
            em.remove(avaliacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    @Override
    public Avaliacao pesquisar(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(Avaliacao.class, id);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Avaliacao> listar() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query consulta = em.createQuery("select a from Avaliacao a");
            return consulta.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

}
