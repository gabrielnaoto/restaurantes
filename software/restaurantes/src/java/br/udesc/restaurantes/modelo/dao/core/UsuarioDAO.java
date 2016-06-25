package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.dao.jpa.exceptions.NonexistentEntityException;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.RollbackFailureException;
import br.udesc.restaurantes.modelo.entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

public interface UsuarioDAO {

    public EntityManager getEntityManager();

    public void create(Usuario usuario) throws RollbackFailureException, Exception;

    public void edit(Usuario usuario) throws NonexistentEntityException, RollbackFailureException, Exception;

    public void destroy(int id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public List<Usuario> findUsuarioEntities();

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult);

    public Usuario findUsuario(int id);

    public int getUsuarioCount();
}
