package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTOBuilder.Director;
import model.PersonaDTO;

public class PersonaDAO extends FactoryDAO<PersonaDTO, Long>{

    public PersonaDAO(Connection con) {
        super(con);
    }

    @Override
    public PersonaDTO save(PersonaDTO entity) {
        Statement s;
        try {
            s = con.createStatement();
            s.executeQuery(
            "INSERT INTO CUENTA_AHORROS (nombre,dni,correo,cel) VALUES ("+entity.getNombre()+","
            +entity.getDni()+","+entity.getCorreo()+","+entity.getCel()+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return entity;
    }

    @Override
    public List<PersonaDTO> findAll() {
        List<PersonaDTO> personas = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENTE");
            
            while(rs.next()){

                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                Long dni = rs.getLong("dni");
                String correo = rs.getString("correo");
                String cel = rs.getString("cel");
                personas.add(Director.makePersona(id, nombre, dni, correo, cel));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    @Override
    public PersonaDTO findByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PersonaDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
