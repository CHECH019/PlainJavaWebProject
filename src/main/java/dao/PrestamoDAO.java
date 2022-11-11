package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTOBuilder.Director;
import model.PrestamoDTO;

public class PrestamoDAO extends FactoryDAO<PrestamoDTO,Long>{

    public PrestamoDAO(Connection con) {
        super(con);
    }

    @Override
    public PrestamoDTO save(PrestamoDTO entity) {
        return null;
    }

    @Override
    public List<PrestamoDTO> findAll() {
        List<PrestamoDTO> prestamos = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM PRESTAMO");
            while(rs.next()){
                
                Long id= rs.getLong("id");
                Long clienteId = rs.getLong("cliente_id");
                Double valor = rs.getDouble("valor");
                int cuotas = rs.getInt("cuotas");
                int intereses = rs.getInt("intereses");
                String descripcion = rs.getString("descripcion");
                prestamos.add(Director.makePrestamo(id, clienteId, valor, cuotas, intereses, descripcion));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }

    @Override
    public PrestamoDTO findByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PrestamoDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
