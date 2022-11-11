package DTOBuilder;

import model.PrestamoDTO;

public class PrestamoBuilder extends Builder <PrestamoDTO>{

    public PrestamoBuilder() {
        super(new PrestamoDTO());
    }

    @Override
    public void setClienteId(Long id) {
        this.dto.setClienteId(id);
    }

    public void setId(Long id) {
        this.dto.setId(id);
    }

    public void setValor(double valor) {
        this.dto.setValor(valor);
    }

    public void setIntereses(int intereses) {
        this.dto.setIntereses(intereses);
    }

    public void setCuotas(int cuotas) {
        this.dto.setCuotas(cuotas);
    }

    public void setDescripcion(String descripcion) {
        this.dto.setDescripcion(descripcion);
    }
    
}
