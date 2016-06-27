package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.entidade.Usuario;
import java.util.List;

public interface UsuarioDAO {

    public void salvar(Usuario usuario);

    public void excluir(Usuario usuario);

    public Usuario pesquisar(int id);

    public List<Usuario> listar();
    
    public Usuario autenticar(String apelido, String senha);
    
    public Usuario apelido(String apelido);
}
