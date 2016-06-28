package br.udesc.restaurantes.modelo.entidade;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="avaliacoes")
public class Avaliacao implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="avaliacao_id")
    private int avaliacaoId;
    
    @Column (name="qualificacao")
    private int qualificacao;
    
    @ManyToOne(cascade=CascadeType.ALL, optional=false)
    @JoinColumn (name="usuario_id")
    private Usuario usuario;
    
    @ManyToOne(cascade=CascadeType.ALL, optional=false)
    @JoinColumn (name="restaurante_id")
    private Restaurante restaurante;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn (name="comentario_id")
    private Comentario comentario;

    public Avaliacao() {
    }

    public Avaliacao(int qualificacao, Usuario usuario, Restaurante restaurante, Comentario comentario) {
        this.qualificacao = qualificacao;
        this.usuario = usuario;
        this.restaurante = restaurante;
        this.comentario = comentario;
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

    public Comentario getComentario() {
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }

   
}
