package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.ProductoDTO;

public class ProductoDAO extends GenericDAO<ProductoDTO,Integer>{

    public ProductoDAO(Connection con) {
        super(con);
    }

    @Override
    public ProductoDTO save(ProductoDTO entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ProductoDTO> findAll() {
        return getProductListFromQuery("SELECT * FROM producto");
    }

    @Override
    public ProductoDTO findByID(Integer id) {
        return getProductListFromQuery("SELECT * FROM producto WHERE id = "+id).get(0);
    }

    @Override
    public ProductoDTO deleteByID(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveClientProduct(Long client_id, Integer product_id){
        Statement s;
        try {
            s = con.createStatement();
            String query = "INSERT INTO cliente_producto VALUES("
            +client_id+","+product_id+")";
            System.out.println(query);
            s.executeUpdate(query);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<ProductoDTO> findProductsByClientId(Long id){
        return getProductListFromQuery("SELECT p.id, p.nombre FROM producto p JOIN cliente_producto cp ON p.id = cp.producto_id JOIN cliente c ON cp.cliente_id = c.id WHERE c.id = "+id);
    }

    private List<ProductoDTO> getProductListFromQuery(String query){
        List<ProductoDTO> productos = new ArrayList<>();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                
                productos.add(new ProductoDTO(id, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
}
