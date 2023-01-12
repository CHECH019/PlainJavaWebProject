package dao;

import java.util.List;

import model.ClienteDTO;

public class ClienteDAO extends GenericDAO<ClienteDTO, Long>{

    @Override
    public ClienteDTO save(ClienteDTO entity) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
        emf.close();
        return entity;
    }

    @Override
    public List<ClienteDTO> findAll() {
        return getClientsListFromQuery("SELECT * FROM CLIENTE LIMIT 200");
    }

    @Override
    public ClienteDTO findByID(Long id) {
        return getClientsListFromQuery("SELECT * FROM CLIENTE WHERE id = "+id).get(0);
    }

    @Override
    public ClienteDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<ClienteDTO> findByNameAndLastName(String name, String lastName){
        return getClientsListFromQuery("SELECT * FROM CLIENTE WHERE nombre = '"+name
        +"' AND apellido = '"+lastName+"'");
    }

    @SuppressWarnings("unchecked")
    private List<ClienteDTO> getClientsListFromQuery(String query){
        List<ClienteDTO> clientes;
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        clientes = manager.createNativeQuery(query).getResultList();
        manager.close();
        emf.close();
        return clientes;
    }
}
