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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="avaliacoes")
public class Avaliacao implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="avaliacao_id")
    private int avaliacaoId;
    
    @Column (name="qualicacao")
    private int qualificacao;
    
    @ManyToOne(cascade=CascadeType.ALL, optional=false)
    @JoinColumn (name="usuario")
    private Usuario usuario;
    
    @ManyToOne(cascade=CascadeType.ALL, optional=false)
    @JoinColumn (name="restaurante")
    private Restaurante restaurante;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn (name="comentarios")
    private List<Comentario> comentarios;

    public Avaliacao() {
    }

    public Avaliacao(int qualificacao, Usuario usuario, Restaurante restaurante, List<Comentario> comentarios) {
        this.qualificacao = qualificacao;
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.comentarios = comentarios;
    }
    
    public void addComentario(String comentario){
        comentarios.add(new Comentario(comentario));
    }

    public int getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(int avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public int getQualificacao() {
        return qualificacao;
    }

    public void setQualificacao(int qualificacao) {
        this.qualificacao = qualificacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    

    @Override
    public String toString() {
        return "Avaliacao{" + "avaliacaoId=" + avaliacaoId + ", qualificacao=" + qualificacao + ", usuario=" + usuario + ", restaurante=" + restaurante + ", comentarios=" + comentarios + '}';
    }
}
