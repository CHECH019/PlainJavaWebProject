package Iterator;

import java.util.ArrayList;
import java.util.List;

import model.PersonaDTO;

public class PersonaCollection implements IterableDTO<PersonaDTO>{
    List<PersonaDTO> listaPersonas;
    
    public PersonaCollection(List<PersonaDTO> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public PersonaCollection() {
        listaPersonas = new ArrayList<>();
    }

    public void agregar(PersonaDTO dto){
        listaPersonas.add(dto);
    }

    public PersonaIterator iterator(){
        return new PersonaIterator(listaPersonas);
    }
    
}
