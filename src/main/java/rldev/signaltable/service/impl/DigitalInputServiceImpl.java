package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.DigitalInputDAO;
import rldev.signaltable.entity.DigitalInput;
import rldev.signaltable.service.DigitalInputService;

import java.util.List;

@Service("digitalInputService")
@Transactional
public class DigitalInputServiceImpl implements DigitalInputService {

    @Autowired
    private DigitalInputDAO digitalInputDAO;

    
    public void save(DigitalInput di) {
        digitalInputDAO.save(di);
    }

    
    public void update(DigitalInput persistent) {
        digitalInputDAO.update(persistent);
    }

    public void deleteById(Long id) {
        digitalInputDAO.deleteById(id);
    }

    
    public void delete(DigitalInput persistent) {
        digitalInputDAO.delete(persistent);
    }

    
    public DigitalInput getById(Long id) {
        return digitalInputDAO.getById(id);
    }

    
    @SuppressWarnings("unchecked")
    public List getAll() {
        return digitalInputDAO.getAll();
    }

    
    public List<DigitalInput> getByAPCSObjectId(Long id) {
        return digitalInputDAO.getByAPCSObjectId(id);
    }
    
    public DigitalInput getBySymbol(String symbol) {
        return digitalInputDAO.getBySymbol(symbol);
    }

    public List<DigitalInput> getByAPCSObjectName(String name) {
        return digitalInputDAO.getByAPCSObjectName(name);
    }
}
