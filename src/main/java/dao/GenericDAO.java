package dao;

import java.sql.Connection;
import java.util.List;

public abstract class GenericDAO<T,ID> {
    protected Connection con;

    public GenericDAO(Connection con){
        this.con = con;
    }
    
    public abstract T save(T entity );
    public abstract List<T> findAll();
    public abstract T findByID(ID id);
    public abstract T deleteByID(ID id);
    
}
