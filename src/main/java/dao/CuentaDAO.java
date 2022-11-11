package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTOBuilder.Director;
import model.CuentaDTO;

public class CuentaDAO extends FactoryDAO<CuentaDTO,Long>{

    public CuentaDAO(Connection con) {
        super(con);
    }

    @Override
    public CuentaDTO save(CuentaDTO entity) {
        return null;
    }

    @Override
    public List<CuentaDTO> findAll() {
        List<CuentaDTO> cuentas = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CUENTA_AHORROS");
            while(rs.next()){
                
                Long id = rs.getLong("id");
                Long clienteId = rs.getLong("cliente_id");
                Double saldo = rs.getDouble("saldo");
                int clave = rs.getInt("clave");
                cuentas.add(Director.makeCuenta(id, clienteId, saldo, clave));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cuentas;
    }

    @Override
    public CuentaDTO findByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CuentaDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}