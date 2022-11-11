package DTOBuilder;

import java.sql.Date;

import model.CuentaDTO;
import model.PersonaDTO;
import model.PrestamoDTO;
import model.TarjetaDTO;

public class Director {

    public static PersonaDTO makePersona(Long id, String nombre, Long dni, String correo, String cel){
        PersonaBuilder personaBuilder = new PersonaBuilder();
        personaBuilder.setId(id);
        personaBuilder.setNombre(nombre);
        personaBuilder.setDni(dni);
        personaBuilder.setCorreo(correo);
        personaBuilder.setCel(cel);
        return personaBuilder.getDTO();
    }

    public static PrestamoDTO makePrestamo(Long id, Long clienteId, double valor, int cuotas, int intereses, String descripcion){
        PrestamoBuilder prestamoBuilder = new PrestamoBuilder();
        prestamoBuilder.setId(id);
        prestamoBuilder.setClienteId(clienteId);
        prestamoBuilder.setValor(valor);
        prestamoBuilder.setCuotas(cuotas);
        prestamoBuilder.setIntereses(intereses);
        prestamoBuilder.setDescripcion(descripcion);
        return prestamoBuilder.getDTO();
    }

    public static CuentaDTO makeCuenta(Long id, Long clienteId, double saldo, int clave){
        CuentaBuilder cuentaBuilder = new CuentaBuilder();
        cuentaBuilder.setId(id);
        cuentaBuilder.setClienteId(clienteId);
        cuentaBuilder.setSaldo(saldo);
        cuentaBuilder.setClave(clave);
        return cuentaBuilder.getDTO();
    }

    public static TarjetaDTO makeTarjeta(Long id, Long clienteId, String numeroTarjeta, Date vencimiento, int cvv){
        TarjetaBuilder tarjeta = new TarjetaBuilder();
        tarjeta.setId(id);
        tarjeta.setClienteId(clienteId);
        tarjeta.setNumeroTarjeta(numeroTarjeta);
        tarjeta.setVencimiento(vencimiento);
        tarjeta.setCvv(cvv);
        return tarjeta.getDTO();
    }
}
