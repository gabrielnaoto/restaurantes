package br.udesc.restaurantes.modelo.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
    
    @Column(name="apelido")
    private String apelido;
    
    @Column(name="data_nascimento")
    private String dataNascimento;
    
    @Column(name="foto")
    private String foto;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="gostos")
    private List<Categoria> gostos;
    
    @Column
    private String nacionalidade;
    
    @Column
    private String nome;
    
    @Column
    private String profissao;
    
    @Id
    @GeneratedValue
    @Column(name="usuario_id")
    private int usuarioId;
    
    @Column
    private String senha;

    public Usuario() {
    }

    public Usuario(String apelido, String dataNascimento, String foto, List<Categoria> gostos, String nacionalidade, String nome, String profissao, int usuarioId) {
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
        this.gostos = gostos;
        this.nacionalidade = nacionalidade;
        this.nome = nome;
        this.profissao = profissao;
        this.usuarioId = usuarioId;
    }

    public Usuario(String apelido, String dataNascimento, String foto, List<Categoria> gostos, String nacionalidade, String nome, String profissao, int usuarioId, String senha) {
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
        this.foto = foto;
        this.gostos = gostos;
        this.nacionalidade = nacionalidade;
        this.nome = nome;
        this.profissao = profissao;
        this.usuarioId = usuarioId;
        this.senha = senha;
    }
    
    
    
    public void addCategoria(String gosto){
        gostos.add(new Categoria(gosto));
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dateNascimento) {
        this.dataNascimento = dateNascimento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Categoria> getGostos() {
        return gostos;
    }

    public void setGostos(List<Categoria> gostos) {
        this.gostos = gostos;
    }

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

    
    @Override
    public String toString() {
        return "Usuario{" + "apelido=" + apelido + ", dataNascimento=" + dataNascimento + ", foto=" + foto + ", gostos=" + gostos + ", nacionalidade=" + nacionalidade + ", nome=" + nome + ", profissao=" + profissao + ", usuarioId=" + usuarioId + '}';
    }
    
    
}