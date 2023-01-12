import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.ClienteDTO;

public class App {

    // @PersistenceContext(unitName = "my_persistence_unit")
    private static EntityManager manager;

    // @PersistenceUnit(unitName = "my_persistence_unit")
    private static EntityManagerFactory emf;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        manager = emf.createEntityManager();

        ClienteDTO cliente = new ClienteDTO("Santiago", "Quijano", "male", "santi123@correo.com", "Cra 100");
            
        // manager.getTransaction().begin();
        // manager.persist(cliente);
        // manager.getTransaction().commit();

        List<ClienteDTO> clientes = manager.createQuery("FROM ClienteDTO").getResultList();

        ClienteDTO x = manager.find(ClienteDTO.class, 2L);


        manager.getTransaction().begin();
        // manager.merge(x);
        manager.remove(x);
        manager.getTransaction().commit();

        clientes.forEach(c->System.out.println(c.getNombre()+" "+c.getId()));


        
        manager.close();
        emf.close();

        System.out.println("ok");
    }
}