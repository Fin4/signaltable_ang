package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AnalogInputDao;
import rldev.signaltable.entity.AnalogInput;
import rldev.signaltable.service.AnalogInputService;

import java.util.List;

@Service("analogInputService")
public class AnalogInputServiceImpl implements AnalogInputService {

    @Autowired
    private AnalogInputDao analogInputDao;

    
    public void save(AnalogInput persistent) {
        analogInputDao.save(persistent);
    }

    
    public void update(AnalogInput persistent) {
        analogInputDao.update(persistent);
    }

    
    public void delete(AnalogInput persistent) {
        analogInputDao.delete(persistent);
    }

    
    public void deleteById(Long id) {
        analogInputDao.deleteById(id);
    }

    
    public AnalogInput getById(Long id) {
        return analogInputDao.getById(id);
    }

    
    public List<AnalogInput> getAll() {
        return analogInputDao.getAll();
    }


    
    public List<AnalogInput> getByProcessControlObjectId(Long id) {
        return analogInputDao.getByProcessControlObjectId(id);
    }

    
    public AnalogInput getBySymbol(String symbol) {
        return analogInputDao.getBySymbol(symbol);
    }

    
    public List<AnalogInput> getByProcessControlObjectName(String name) {
        return analogInputDao.getByProcessControlObjectName(name);
    }
}
