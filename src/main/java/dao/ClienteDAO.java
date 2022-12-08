package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ClienteDTO;

public class ClienteDAO extends GenericDAO<ClienteDTO, Long>{

    private String query;

    public ClienteDAO(Connection con) {
        super(con);
    }

    @Override
    public ClienteDTO save(ClienteDTO entity) {
        Statement s;
        try {
            s = con.createStatement();
            query = "INSERT INTO cliente (nombre,apellido,genero,correo,direccion) VALUES ('"
            +entity.getNombre()+"','"+entity.getApellido()+"','"+entity.getGenero()+"','"+entity.getCorreo()+"','"+entity.getDireccion()+"')";
            System.out.println(query);
            s.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return entity;
    }

    @Override
    public List<ClienteDTO> findAll() {
        return getClientsListFromQuery("SELECT * FROM CLIENTE LIMIT 200");
    }

    @Override
    public ClienteDTO findByID(Long id) {
        return getClientsListFromQuery("SELECT * FROM CLIENTE WHERE id = "+id).get(0);
    }

    @Override
    public ClienteDTO deleteByID(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
    
    public List<ClienteDTO> findByNameAndLastName(String name, String lastName){
        return getClientsListFromQuery("SELECT * FROM CLIENTE WHERE nombre = '"+name
        +"' AND apellido = '"+lastName+"'");
    }
    private List<ClienteDTO> getClientsListFromQuery(String query){
        List<ClienteDTO> clientes = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                Long id = rs.getLong("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String correo = rs.getString("correo");
                String genero = rs.getString("genero");
                String direccion = rs.getString("direccion");
                clientes.add(new ClienteDTO(id, nombre, apellido, genero, correo, direccion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
