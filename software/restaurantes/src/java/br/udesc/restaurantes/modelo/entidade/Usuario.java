package br.udesc.restaurantes.modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@NamedQueries({
    @NamedQuery(name = "Usuario.findByApelido", query = "SELECT u FROM Usuario u WHERE u.apelido = :ap"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha")})
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "data_nascimento")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "foto")
    private String foto;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "categoria_id")
//    private List<Categoria> gostos;
//    
    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "nome")
    private String nome;

    @Column(name = "profissao")
    private String profissao;

    @Id
    @GeneratedValue
    @Column(name = "usuario_id")
    private int usuarioId;

    @Column(name = "senha")
    private String senha;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "avaliacao_id")
    private List<Avaliacao> avaliacoes;

    public Usuario() {
    }

    public Usuario(String apelido, Date dataNascimento, String foto, String nacionalidade, String nome, String profissao, int usuarioId, String senha, List<Avaliacao> avaliacoes) {
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
        this.nacionalidade = nacionalidade;
        this.nome = nome;
        this.profissao = profissao;
        this.usuarioId = usuarioId;
        this.senha = senha;
        this.avaliacoes = avaliacoes;
    }

    public Usuario(String apelido, Date dataNascimento, String foto, String nacionalidade, String nome, String profissao, String senha, List<Avaliacao> avaliacoes) {
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
        this.nacionalidade = nacionalidade;
        this.nome = nome;
        this.profissao = profissao;
        this.senha = senha;
        this.avaliacoes = avaliacoes;
    }

//    public void addCategoria(String gosto) {
//        gostos.add(new Categoria(gosto));
//    }
    public void addAvaliacoes(Avaliacao a) {
        avaliacoes.add(a);
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

//    public List<Categoria> getGostos() {
//        return gostos;
//    }
//
//    public void setGostos(List<Categoria> gostos) {
//        this.gostos = gostos;
//    }
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

}
