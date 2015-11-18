package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.APCSObjectDAO;
import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.service.APCSObjectService;

import java.util.List;

@Service("apcsObjectService")
@Transactional
public class APCSObjectServiceImpl implements APCSObjectService {

    @Autowired
    private APCSObjectDAO apcsObjectDAO;

    
    public void save(APCSObject persistent) {
        apcsObjectDAO.save(persistent);
    }

    
    public void update(APCSObject persistent) {
        apcsObjectDAO.update(persistent);
    }

    
    public void delete(APCSObject persistent) {
        apcsObjectDAO.delete(persistent);
    }

    
    public void deleteById(Long id) {
        apcsObjectDAO.deleteById(id);
    }

    
    public APCSObject getById(Long id) {
        return apcsObjectDAO.getById(id);
    }

    
    public APCSObject getByName(String name) {
        return apcsObjectDAO.getByName(name);
    }

    
    public List<APCSObject> getAll() {
        return apcsObjectDAO.getAll();
    }

    
    public List<APCSObject> getAllObjectsByDirectionName(String name) {
        return apcsObjectDAO.getAllObjectsByDirectionName(name);
    }

    
    public List<APCSObject> getAllObjectsByDirectionId(Long id) {
        return apcsObjectDAO.getAllObjectsByDirectionId(id);
    }

    
    public APCSObject getApcsObjectBySymbol(String symbol) {
        return apcsObjectDAO.getApcsObjectBySymbol(symbol);
    }


}
