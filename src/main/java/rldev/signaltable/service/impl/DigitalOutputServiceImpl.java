package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.DigitalOutputDAO;
import rldev.signaltable.entity.DigitalOutput;
import rldev.signaltable.service.DigitalOutputService;

import java.util.List;

@Service("digitalOutputService")
@Transactional
public class DigitalOutputServiceImpl implements DigitalOutputService {

    @Autowired
    private DigitalOutputDAO digitalOutputDAO;

    
    public void save(DigitalOutput persistent) {
        digitalOutputDAO.save(persistent);
    }

    
    public void update(DigitalOutput persistent) {
        digitalOutputDAO.update(persistent);
    }

    
    public void delete(DigitalOutput persistent) {
        digitalOutputDAO.delete(persistent);
    }

    
    public void deleteById(Long id) {
        digitalOutputDAO.deleteById(id);
    }

    
    public DigitalOutput getById(Long id) {
        return digitalOutputDAO.getById(id);
    }

    
    public List<DigitalOutput> getAll() {
        return digitalOutputDAO.getAll();
    }


    
    public List<DigitalOutput> getByAPCSObjectId(Long id) {
        return digitalOutputDAO.getByAPCSObjectId(id);
    }

    
    public DigitalOutput getBySymbol(String symbol) {
        return digitalOutputDAO.getBySymbol(symbol);
    }

    
    public List<DigitalOutput> getByAPCSObjectName(String name) {
        return digitalOutputDAO.getByAPCSObjectName(name);
    }
}
