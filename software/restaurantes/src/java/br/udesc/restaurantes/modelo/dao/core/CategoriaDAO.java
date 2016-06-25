package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.dao.jpa.exceptions.NonexistentEntityException;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.RollbackFailureException;
import br.udesc.restaurantes.modelo.entidade.Categoria;
import java.util.List;

public interface CategoriaDAO {

    public void create(Categoria categoria) throws RollbackFailureException, Exception;

    public void edit(Categoria categoria) throws NonexistentEntityException, RollbackFailureException, Exception;

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public List<Categoria> findCategoriaEntities();

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult);

    public Categoria findCategoria(int id);

    public int getCategoriaCount();
}
