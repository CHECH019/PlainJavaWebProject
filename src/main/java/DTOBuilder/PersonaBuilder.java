package DTOBuilder;

import model.PersonaDTO;

public class PersonaBuilder extends Builder<PersonaDTO>{

    public PersonaBuilder() {
        super(new PersonaDTO());
    }

    public void setNombre(String nombre) {
        this.dto.setNombre(nombre);
    }
    
    public void setDni(Long dni) {
        this.dto.setDni(dni);
    }
    
    public void setCorreo(String correo) {
        this.dto.setCorreo(correo);
    }
   
    public void setCel(String cel) {
        this.dto.setCel(cel);
    }

    @Override
    public void setId(Long id) {
        this.dto.setId(id);
    }
    
    @Override
    public void setClienteId(Long id) {}

}
