package dao;

import java.util.List;

import model.ProductoDTO;

public class ProductoDAO extends GenericDAO<ProductoDTO,Integer>{


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
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        String query = "INSERT INTO cliente_producto VALUES(:client_id, :product_id)";
        manager.createNativeQuery(query)
        .setParameter("client_id", client_id)
        .setParameter( "product_id", client_id)
        .executeUpdate();
        manager.getTransaction().commit();
        manager.close();
        emf.close();

        
    }

    public List<ProductoDTO> findProductsByClientId(Long id){
        return getProductListFromQuery("SELECT p.id, p.nombre FROM producto p JOIN cliente_producto cp ON p.id = cp.producto_id JOIN cliente c ON cp.cliente_id = c.id WHERE c.id = "+id);
    }
    @SuppressWarnings("unchecked")
    private List<ProductoDTO> getProductListFromQuery(String query){
        List<ProductoDTO> productos;
        manager = emf.createEntityManager();
        manager.getTransaction().begin();
        productos = manager.createNativeQuery(query).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return productos;
    }
}
