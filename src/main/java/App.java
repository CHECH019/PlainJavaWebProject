import controladores.DBConnection;
import dao.PersonaDAO;

public class App {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO(DBConnection.getConnection());
        personaDAO.findAll().forEach(p -> System.out.println(p.getNombre()));
    }
}
