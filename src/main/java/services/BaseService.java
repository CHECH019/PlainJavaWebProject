package services;

import java.util.List;

import dao.GenericDAO;


public abstract class BaseService<T,ID> {
    
    protected GenericDAO<T,ID> dao;

    
    
    public BaseService(GenericDAO<T, ID> dao) {
        this.dao = dao;
    }

    public List<T> getAll(){
        return dao.findAll();
    }

    public T getById(ID id){
        return dao.findByID(id);
    }

    public T save(T entity){
        return dao.save(entity);
    }

    public T deleteById(ID id){
        return dao.deleteByID(id);
    }

}
