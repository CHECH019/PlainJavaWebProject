package dao;

import java.util.List;

import jakarta.servlet.ServletContext;
import model.ClienteDTO;

public class ClienteDAO extends GenericDAO<ClienteDTO, Long>{

    public ClienteDAO(ServletContext servletContext) {
        super(servletContext);
        //TODO Auto-generated constructor stub
    }

    @Override
    public ClienteDTO save(ClienteDTO entity) {
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(entity);
        manager.getTransaction().commit();
        manager.close();
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteDTO> clientes;
        manager = emf.createEntityManager();
        clientes = manager.createQuery("FROM ClienteDTO").getResultList();
        manager.close();
        return clientes;
    }

    @Override
    public ClienteDTO findByID(Long id) {
        manager = emf.createEntityManager();
        ClienteDTO c = manager.find(ClienteDTO.class, id);
        manager.close();
        return c;
    }

    @Override
    public ClienteDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @SuppressWarnings("unchecked")
    public List<ClienteDTO> findByNameAndLastName(String name, String lastName){
        List<ClienteDTO> clientes;
        manager = emf.createEntityManager();
        clientes = manager.createQuery("FROM ClienteDTO WHERE nombre = : nombre AND apellido = :apellido").setParameter("nombre", name).setParameter("apellido", lastName).getResultList();
        return clientes;
    }

}
