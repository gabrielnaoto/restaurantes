package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.entidade.Restaurante;
import java.util.List;

public interface RestauranteDAO {

    public void salvar(Restaurante restaurante);

    public void excluir(Restaurante restaurante);
    
    public Restaurante pesquisar(int id);
    
    public List<Restaurante> listar();

    public Restaurante consultar(String r);
}
