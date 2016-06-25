package br.udesc.restaurantes.modelo.dao.jpa;

import br.udesc.restaurantes.modelo.dao.core.AvaliacaoDAO;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.NonexistentEntityException;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.RollbackFailureException;
import br.udesc.restaurantes.modelo.entidade.Avaliacao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

public class JPAAvaliacaoDAO implements Serializable, AvaliacaoDAO {

    public JPAAvaliacaoDAO(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }

    public JPAAvaliacaoDAO() {
        emf = Persistence.createEntityManagerFactory("RestaurantePU");
    }
    
    
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Avaliacao avaliacao) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(avaliacao);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Avaliacao avaliacao) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            avaliacao = em.merge(avaliacao);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = avaliacao.getAvaliacaoId();
                if (findAvaliacao(id) == null) {
                    throw new NonexistentEntityException("The avaliacao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Avaliacao avaliacao;
            try {
                avaliacao = em.getReference(Avaliacao.class, id);
                avaliacao.getAvaliacaoId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The avaliacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(avaliacao);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Avaliacao> findAvaliacaoEntities() {
        return findAvaliacaoEntities(true, -1, -1);
    }

    @Override
    public List<Avaliacao> findAvaliacaoEntities(int maxResults, int firstResult) {
        return findAvaliacaoEntities(false, maxResults, firstResult);
    }

    private List<Avaliacao> findAvaliacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Avaliacao.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Avaliacao findAvaliacao(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Avaliacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getAvaliacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Avaliacao> rt = cq.from(Avaliacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
