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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurantes")
@NamedQuery(name = "Restaurante.findByNome", query = "SELECT r FROM Restaurante r WHERE r.nomeEstabelecimento = :re")
public class Restaurante implements Serializable {

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nome_estabelecimento")
    private String nomeEstabelecimento;

    @Id
    @GeneratedValue
    @Column(name = "restaurante_id")
    private int restauranteId;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    @OneToMany(mappedBy = "restaurante")
    private List<Avaliacao> avaliacoes;

    @Column(name = "fotos")
    private List<String> fotos;

    //@Transient
    @Column(name="avaliacao")
    private int avaliacao;

    public Restaurante() {
    }

    public Restaurante(String descricao, String nomeEstabelecimento, Categoria categoria, List<String> fotos) {
        this.descricao = descricao;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.categoria = categoria;
        this.fotos = fotos;
    }

    public Restaurante(String descricao, String nomeEstabelecimento, Categoria categoria) {
        this.descricao = descricao;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.categoria = categoria;
    }

    public void addFotos(String foto) {
        fotos.add(foto);
    }
    
    public void addAvaliacao (Avaliacao a){
        avaliacoes.add(a);
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

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

}
