package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.dao.jpa.exceptions.NonexistentEntityException;
import br.udesc.restaurantes.modelo.dao.jpa.exceptions.RollbackFailureException;
import br.udesc.restaurantes.modelo.entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;

public interface UsuarioDAO {

    public void salvar(Usuario usuario);

    public void excluir(Usuario usuario);

    public Usuario pesquisar(int id);

    public List<Usuario> listar();
    
    public Usuario apelido(String apelido);
}
