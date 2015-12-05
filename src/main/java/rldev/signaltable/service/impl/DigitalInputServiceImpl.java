package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.DigitalInputDao;
import rldev.signaltable.entity.DigitalInput;
import rldev.signaltable.service.DigitalInputService;

import java.util.List;

@Service("digitalInputService")
public class DigitalInputServiceImpl implements DigitalInputService {

    @Autowired
    private DigitalInputDao digitalInputDao;

    
    public void save(DigitalInput di) {
        digitalInputDao.save(di);
    }

    
    public void update(DigitalInput persistent) {
        digitalInputDao.update(persistent);
    }

    public void deleteById(Long id) {
        digitalInputDao.deleteById(id);
    }

    
    public void delete(DigitalInput persistent) {
        digitalInputDao.delete(persistent);
    }

    
    public DigitalInput getById(Long id) {
        return digitalInputDao.getById(id);
    }

    
    @SuppressWarnings("unchecked")
    public List getAll() {
        return digitalInputDao.getAll();
    }

    
    public List<DigitalInput> getByProcessControlObjectId(Long id) {
        return digitalInputDao.getByProcessControlObjectId(id);
    }
    
    public DigitalInput getBySymbol(String symbol) {
        return digitalInputDao.getBySymbol(symbol);
    }

    public List<DigitalInput> getByProcessControlObjectName(String name) {
        return digitalInputDao.getByProcessControlObjectName(name);
    }
}
