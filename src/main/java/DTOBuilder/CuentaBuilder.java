package DTOBuilder;

import model.CuentaDTO;

public class CuentaBuilder extends Builder<CuentaDTO>{

    public CuentaBuilder() {
        super(new CuentaDTO());
    }

    @Override
    public void setClienteId(Long id) {
        this.dto.setClienteId(id);
    }

    public void setId(Long id) {
        this.dto.setId(id);
    }

    public void setSaldo(double saldo) {
        this.dto.setSaldo(saldo);
    }

    public void setClave(int clave) {
        this.dto.setClave(clave);
    }
    
}
