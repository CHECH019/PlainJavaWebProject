package model;

public class PersonaDTO {

    private Long id;

    private String nombre;

    private Long dni;

    private String correo;

    private String cel;

    

    public PersonaDTO() {}
    
    public PersonaDTO(Long id, String nombre, Long dni, String correo, String cel) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.cel = cel;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Long getDni() {
        return dni;
    }
    public void setDni(Long dni) {
        this.dni = dni;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getCel() {
        return cel;
    }
    public void setCel(String cel) {
        this.cel = cel;
    }

    
}
