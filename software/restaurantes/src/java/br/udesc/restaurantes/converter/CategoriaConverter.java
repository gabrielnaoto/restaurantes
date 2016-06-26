/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.restaurantes.converter;

import br.udesc.restaurantes.modelo.dao.core.JPAFactory;
import br.udesc.restaurantes.modelo.entidade.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoriaConverter", forClass = Categoria.class)
public class CategoriaConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
         if (!value.equals("0")) {
            return (Categoria) JPAFactory.getCategoriaDAO().pesquisar(Integer.parseInt(value));
         }
        return null;
    }

    @Override
    public String getAsString(FacesContext ctx, UIComponent component, Object value) {
          Categoria p;

        try {
            p = (Categoria) value;
        } catch (Exception e) {
           p = new Categoria();
        }

        return String.valueOf(p.getCategoriaId());
    }
}
