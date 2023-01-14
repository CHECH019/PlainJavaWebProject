package controladores;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class EMF implements ServletContextListener{
    private static final String PERSISTENCE_UNIT_NAME = "my_persistence_unit";
    private static EntityManagerFactory emf;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        sce.getServletContext().setAttribute("emf", emf);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        emf.close();
    }
}
