package br.udesc.restaurantes.modelo.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurantes")
public class Restaurante implements Serializable {
    
    @Column(name="descricao")
    private String descricao;
    
    @Column(name="nome_estabelecimento")
    private String nomeEstabelecimento;
    
    @Id
    @GeneratedValue
    @Column(name="restaurante_id")
    private int restauranteId;
    
    @ManyToOne(cascade=CascadeType.ALL, optional=false)
    @JoinColumn(name="categoria")
    private Categoria categoria;
    
    @Column(name="fotos")
    private List<String> fotos;

    public Restaurante() {
    }

    public Restaurante(String descricao, String nomeEstabelecimento, Categoria categoria, List<String> fotos) {
        this.descricao = descricao;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.categoria = categoria;
        this.fotos = fotos;
    }
    
    public void addFotos(String foto){
        fotos.add(foto);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public int getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(int restauranteId) {
        this.restauranteId = restauranteId;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    @Override
    public String toString() {
        return "Restaurante{" + "descricao=" + descricao + ", nomeEstabelecimento=" + nomeEstabelecimento + ", restauranteId=" + restauranteId + ", categoria=" + categoria + ", fotos=" + fotos + '}';
    }
    
}
