package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.dao.jpa.exceptions.NonexistentEntityException;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.RollbackFailureException;
import br.udesc.restaurantes.modelo.entidade.Avaliacao;
import java.util.List;
import javax.persistence.EntityManager;

public interface AvaliacaoDAO {

    public EntityManager getEntityManager();

    public void create(Avaliacao avaliacao) throws RollbackFailureException, Exception;

    public void edit(Avaliacao avaliacao) throws NonexistentEntityException, RollbackFailureException, Exception;

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public List<Avaliacao> findAvaliacaoEntities();

    public List<Avaliacao> findAvaliacaoEntities(int maxResults, int firstResult);

    public Avaliacao findAvaliacao(int id);

    public int getAvaliacaoCount();

}
