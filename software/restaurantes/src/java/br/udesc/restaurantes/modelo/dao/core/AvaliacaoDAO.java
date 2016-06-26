package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.entidade.Avaliacao;
import java.util.List;

public interface AvaliacaoDAO {

    public void salvar(Avaliacao avaliacao);

    public void excluir(Avaliacao avaliacao);

    public Avaliacao pesquisar(int id);

    public List<Avaliacao> listar();
}
