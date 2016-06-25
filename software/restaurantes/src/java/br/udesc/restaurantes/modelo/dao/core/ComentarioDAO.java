package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.dao.jpa.exceptions.NonexistentEntityException;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.RollbackFailureException;
import br.udesc.restaurantes.modelo.entidade.Comentario;
import java.util.List;
import javax.persistence.EntityManager;

public interface ComentarioDAO {

    public EntityManager getEntityManager();

    public void create(Comentario comentario) throws RollbackFailureException, Exception;

    public void edit(Comentario comentario) throws NonexistentEntityException, RollbackFailureException, Exception;

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public List<Comentario> findComentarioEntities();

    public List<Comentario> findComentarioEntities(int maxResults, int firstResult);

    public Comentario findComentario(int id);

    public int getComentarioCount();
}
