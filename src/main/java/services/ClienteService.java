package services;

import java.util.List;

import dao.ClienteDAO;
import dao.GenericDAO;
import model.ClienteDTO;

public class ClienteService extends BaseService<ClienteDTO,Long>{

    ClienteDAO dao;

    public ClienteService(ClienteDAO dao) {
        this.dao = dao;
    }
   
    public List<ClienteDTO> getClientByNameAndLastName(String name, String lastName){
        return dao.findByNameAndLastName(name, lastName);
    }

    @Override
    public GenericDAO<ClienteDTO, Long> getDao() {
        return dao;
    }
}
