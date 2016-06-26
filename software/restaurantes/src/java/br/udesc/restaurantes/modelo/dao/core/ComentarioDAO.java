package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.entidade.Comentario;
import java.util.List;

public interface ComentarioDAO {

     public void salvar(Comentario comentario);

    public void excluir(Comentario comentario);

    public Comentario pesquisar(int id);

    public List<Comentario> listar();
}
