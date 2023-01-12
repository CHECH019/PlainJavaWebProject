package controladores;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DBConnection {
    private static final String PERSISTENCE_UNIT_NAME = "my_persistence_unit";
    private static EntityManagerFactory emf;
    
    private DBConnection(){}

    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            System.out.println("Conexión exitosa");
        }
        return emf;
    }
}
