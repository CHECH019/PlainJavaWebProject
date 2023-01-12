package dao;

import java.util.List;

import controladores.DBConnection;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public abstract class GenericDAO<T,ID> {
    protected EntityManagerFactory emf;
    EntityManager manager;

    public GenericDAO(){
        this.emf = DBConnection.getEntityManagerFactory();
    }
    
    public abstract T save(T entity );
    public abstract List<T> findAll();
    public abstract T findByID(ID id);
    public abstract T deleteByID(ID id);
    
}
