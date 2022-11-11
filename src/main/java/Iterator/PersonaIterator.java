package Iterator;

import java.util.List;

import model.PersonaDTO;

public class PersonaIterator implements Iterator<PersonaDTO> {

    private List<PersonaDTO> listaPersonas;
    private int currentPosition;

    public PersonaIterator(List<PersonaDTO> listaPersonas) {
        this.listaPersonas = listaPersonas;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < listaPersonas.size();
    }

    @Override
    public PersonaDTO next() {
        return listaPersonas.get(currentPosition++);
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}