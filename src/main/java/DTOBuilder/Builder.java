package DTOBuilder;

public abstract class Builder <T>{
    protected T dto;
    
    public Builder(T dto) {
        this.dto = dto;
    }

    public T getDTO(){
        return dto;
    };
    
    public abstract void setClienteId(Long id );

    public abstract void setId(Long id);
    
}
