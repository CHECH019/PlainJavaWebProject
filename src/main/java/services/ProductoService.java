package services;

import java.util.List;

import dao.GenericDAO;
import dao.ProductoDAO;
import model.ProductoDTO;

public class ProductoService extends BaseService<ProductoDTO,Integer> {
    ProductoDAO dao;
    
    public ProductoService(ProductoDAO dao) {
        this.dao = dao;
    }

    @Override
    public GenericDAO<ProductoDTO, Integer> getDao() {
        return dao;
    }
    
    public List<ProductoDTO> getByClientId(Long id) {
        return dao.findProductsByClientId(id);
    }

    public void saveClienteProducto(Long client_id, Integer product_id) {
        dao.saveClientProduct(client_id, product_id);
    }

}
