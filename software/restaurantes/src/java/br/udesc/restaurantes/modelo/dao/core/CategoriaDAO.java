package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.entidade.Categoria;
import java.util.List;

public interface CategoriaDAO {

     public void salvar(Categoria categoria);

    public void excluir(Categoria categoria);

    public Categoria pesquisar(int id);

    public List<Categoria> listar();
}
