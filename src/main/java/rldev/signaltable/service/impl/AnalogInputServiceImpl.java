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

    @Override
    public void save(AnalogInput persistent) {
        analogInputDAO.save(persistent);
    }

    @Override
    public void update(AnalogInput persistent) {
        analogInputDAO.update(persistent);
    }

    @Override
    public void delete(AnalogInput persistent) {
        analogInputDAO.delete(persistent);
    }

    @Override
    public void deleteById(Long id) {
        analogInputDAO.deleteById(id);
    }

    @Override
    public AnalogInput getById(Long id) {
        return analogInputDAO.getById(id);
    }

    @Override
    public List<AnalogInput> getAll() {
        return analogInputDAO.getAll();
    }


    @Override
    public List<AnalogInput> getByAPCSObjectId(Long id) {
        return analogInputDAO.getByAPCSObjectId(id);
    }

    @Override
    public AnalogInput getByName(String name) {
        return analogInputDAO.getByName(name);
    }

    @Override
    public AnalogInput getBySymbol(String symbol) {
        return analogInputDAO.getBySymbol(symbol);
    }

    @Override
    public List<AnalogInput> getByAPCSObjectName(String name) {
        return analogInputDAO.getByAPCSObjectName(name);
    }
}
