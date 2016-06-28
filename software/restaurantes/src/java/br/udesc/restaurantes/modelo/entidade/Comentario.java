package br.udesc.restaurantes.modelo.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comentarios")
public class Comentario implements Serializable{
    
    @Column(name="comentario")
    private String comentario;
    
    @Id
    @GeneratedValue    
    @Column(name="comentario_id")
    private int comentarioId;

    public Comentario() {
    }

    public Comentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(int comentarioId) {
        this.comentarioId = comentarioId;
    }
}
