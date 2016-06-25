package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.dao.jpa.exceptions.NonexistentEntityException;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.RollbackFailureException;
import br.udesc.restaurantes.modelo.entidade.Restaurante;
import java.util.List;
import javax.persistence.EntityManager;

public interface RestauranteDAO {

    public EntityManager getEntityManager();

    public void create(Restaurante restaurante) throws RollbackFailureException, Exception;

    public void edit(Restaurante restaurante) throws NonexistentEntityException, RollbackFailureException, Exception;

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public List<Restaurante> findRestauranteEntities();

    public List<Restaurante> findRestauranteEntities(int maxResults, int firstResult);

    public Restaurante findRestaurante(int id);

    public int getRestauranteCount();

}
