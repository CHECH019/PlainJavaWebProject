package services;

import dao.GenericDAO;
import model.ClienteDTO;

public class ClienteService extends BaseService<ClienteDTO,Long>{

    public ClienteService(GenericDAO<ClienteDTO, Long> dao) {
        super(dao);
    }
   
}
