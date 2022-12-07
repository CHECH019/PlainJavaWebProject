package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ClienteDTO;

public class ClienteDAO extends GenericDAO<ClienteDTO, Long>{

    public ClienteDAO(Connection con) {
        super(con);
    }

    @Override
    public ClienteDTO save(ClienteDTO entity) {
        Statement s;
        try {
            s = con.createStatement();
            s.executeQuery(
            "INSERT INTO cliente (id,nombre,apellido,genero,correo,direccion) VALUES ("+entity.getNombre()+","
            +entity.getId()+","+entity.getNombre()+","+entity.getApellido()+","
            +entity.getGenero()+","+entity.getCorreo()+","+entity.getDireccion()+")");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return entity;
    }

    @Override
    public List<ClienteDTO> findAll() {
        List<ClienteDTO> personas = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM CLIENTE LIMIT 200");
            
            while(rs.next()){

                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String genero = rs.getString("genero");
                String direccion = rs.getString("direccion");
                personas.add(new ClienteDTO(id, nombre, apellido, genero, correo, direccion));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personas;
    }

    @Override
    public ClienteDTO findByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ClienteDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
