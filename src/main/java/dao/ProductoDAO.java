package dao;

import java.util.List;

import jakarta.servlet.ServletContext;
import model.ProductoDTO;

public class ProductoDAO extends GenericDAO<ProductoDTO,Integer>{


    public ProductoDAO(ServletContext servletContext) {
        super(servletContext);
        //TODO Auto-generated constructor stub
    }

    @Override
    public ProductoDTO save(ProductoDTO entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ProductoDTO> findAll() {
        List<ProductoDTO> productos;
        manager = emf.createEntityManager();
        productos = manager.createQuery("FROM ProductoDTO").getResultList();
        manager.close();
        return productos;
    }

    @Override
    public ProductoDTO findByID(Integer id) {
        ProductoDTO p;
        manager = emf.createEntityManager();
        p = manager.find(ProductoDTO.class, id);
        manager.close();
        return p;
    }

    @Override
    public ProductoDTO deleteByID(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public void saveClientProduct(Long client_id, Integer product_id){
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        String query = "INSERT INTO cliente_producto VALUES(?,?)";
        manager.createNativeQuery(query)
        .setParameter(1, client_id)
        .setParameter( 2, product_id)
        .executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        
    }

    @SuppressWarnings("unchecked")
    public List<ProductoDTO> findProductsByClientId(Long id){
        List<ProductoDTO> productos;
        manager = emf.createEntityManager();
        productos = (List<ProductoDTO>)manager.createNativeQuery("SELECT * FROM producto p JOIN cliente_producto cp ON p.id = cp.producto_id JOIN cliente c ON cp.cliente_id = c.id WHERE c.id = ?",ProductoDTO.class).setParameter( 1, id).getResultList();
        manager.close();
        return productos;
    }
    
}
