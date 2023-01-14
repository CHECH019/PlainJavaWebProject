package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.servlet.ServletContext;

public abstract class GenericDAO<T,ID> {
    protected EntityManagerFactory emf;
    EntityManager manager;

    public GenericDAO(ServletContext servletContext){
        this.emf = (EntityManagerFactory) servletContext.getAttribute("emf");
    }
    
    public abstract T save(T entity );
    public abstract List<T> findAll();
    public abstract T findByID(ID id);
    public abstract T deleteByID(ID id);
    
}
