package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTOBuilder.Director;
import model.TarjetaDTO;

public class TarjetaDAO extends FactoryDAO<TarjetaDTO,Long> {

    public TarjetaDAO(Connection con) {
        super(con);
        //TODO Auto-generated constructor stub
    }

    @Override
    public TarjetaDTO save(TarjetaDTO entity) {
        Statement s;
        try {
            s = con.createStatement();
            s.executeQuery(
            "INSERT INTO CUENTA_AHORROS (numero_tarjeta,vencimiento,cvv,cliente_id"
            + ") VALUES ("+entity.getNumeroTarjeta()+","+entity.getVencimiento()+","+entity.getCvv()+","
             + ""+entity.getClienteId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List<TarjetaDTO> findAll() {
        List<TarjetaDTO> tarjetas = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM TARJETA_DEBITO");
            
            while(rs.next()){
                Long id = rs.getLong("id");
                Long clienteId = rs.getLong("cliente_id");
                String numeroTarjeta = rs.getString("numero_tarjeta");
                Date vencimiento = rs.getDate("vencimiento");
                int cvv = rs.getInt("cvv");

                tarjetas.add(Director.makeTarjeta(id, clienteId, numeroTarjeta, vencimiento, cvv));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarjetas;
    }

    @Override
    public TarjetaDTO findByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TarjetaDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
