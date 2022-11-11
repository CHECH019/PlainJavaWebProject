package DTOBuilder;

import java.sql.Date;

import model.TarjetaDTO;

public class TarjetaBuilder extends Builder<TarjetaDTO>{

    public TarjetaBuilder() {
        super(new TarjetaDTO());
    }

    @Override
    public void setClienteId(Long id) {
        this.dto.setClienteId(id);
        
    }

    @Override
    public void setId(Long id) {
        this.dto.setId(id);   
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.dto.setNumeroTarjeta(numeroTarjeta);
    }

    public void setCvv(int cvv) {
        this.dto.setCvv(cvv);
    }

    public void setVencimiento(Date vencimiento) {
        this.dto.setVencimiento(vencimiento);
    }
   
}
