package br.udesc.restaurantes.modelo.dao.core;

import br.udesc.restaurantes.modelo.dao.jpa.JPAAvaliacaoDAO;
import br.udesc.restaurantes.modelo.dao.jpa.JPACategoriaDAO;
import br.udesc.restaurantes.modelo.dao.jpa.JPAComentarioDAO;
import br.udesc.restaurantes.modelo.dao.jpa.JPARestauranteDAO;
import br.udesc.restaurantes.modelo.dao.jpa.JPAUsuarioDAO;

public abstract class JPAFactory {
    public static AvaliacaoDAO getAvaliacaoDAO(){
        return new JPAAvaliacaoDAO();
    }
    
    public static CategoriaDAO getCategoriaDAO(){
        return new JPACategoriaDAO();
    }
    
    public static ComentarioDAO getComentarioDAO(){
        return new JPAComentarioDAO();
    }
    
    public static RestauranteDAO getRestauranteDAO(){
        return new JPARestauranteDAO();
    }
    
    public static UsuarioDAO getUsuarioDAO(){
        return new JPAUsuarioDAO();
    }
}
