package services;

import java.util.List;

import dao.GenericDAO;


public abstract class BaseService<T,ID> {
    

    public List<T> getAll(){
        return getDao().findAll();
    }

    public T getById(ID id){
        return getDao().findByID(id);
    }

    public T save(T entity){
        return getDao().save(entity);
    }

    public T deleteById(ID id){
        return getDao().deleteByID(id);
    }

    public abstract GenericDAO<T,ID> getDao();

}
