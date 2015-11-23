package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AnalogInputDAO;
import rldev.signaltable.entity.AnalogInput;
import rldev.signaltable.service.AnalogInputService;

import java.util.List;

@Service("analogInputService")
@Transactional
public class AnalogInputServiceImpl implements AnalogInputService {

    @Autowired
    private AnalogInputDAO analogInputDAO;

    
    public void save(AnalogInput persistent) {
        analogInputDAO.save(persistent);
    }

    
    public void update(AnalogInput persistent) {
        analogInputDAO.update(persistent);
    }

    
    public void delete(AnalogInput persistent) {
        analogInputDAO.delete(persistent);
    }

    
    public void deleteById(Long id) {
        analogInputDAO.deleteById(id);
    }

    
    public AnalogInput getById(Long id) {
        return analogInputDAO.getById(id);
    }

    
    public List<AnalogInput> getAll() {
        return analogInputDAO.getAll();
    }


    
    public List<AnalogInput> getByAPCSObjectId(Long id) {
        return analogInputDAO.getByAPCSObjectId(id);
    }

    
    public AnalogInput getBySymbol(String symbol) {
        return analogInputDAO.getBySymbol(symbol);
    }

    
    public List<AnalogInput> getByAPCSObjectName(String name) {
        return analogInputDAO.getByAPCSObjectName(name);
    }
}
