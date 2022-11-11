
import Iterator.Iterator;
import Iterator.PersonaCollection;
import controladores.DBConnection;
import dao.PersonaDAO;
import model.PersonaDTO;

public class App {
    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO(DBConnection.getConnection());
        PersonaCollection listaPersonas = new PersonaCollection(personaDAO.findAll());
        Iterator<PersonaDTO> iterator = listaPersonas.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getNombre());
        }
    }
}
