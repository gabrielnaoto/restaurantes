package br.udesc.restaurantes.bean;

import br.udesc.restaurantes.modelo.entidade.Categoria;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name="avaliacaobean")
public class BeanAvaliacao implements Serializable{

    public void fazer() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("RestaurantePU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
             Categoria c = new Categoria();
             c.setNome("Luma");
             em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
