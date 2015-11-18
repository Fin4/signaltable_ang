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

    @Override
    public void save(DigitalOutput persistent) {
        digitalOutputDAO.save(persistent);
    }

    @Override
    public void update(DigitalOutput persistent) {
        digitalOutputDAO.update(persistent);
    }

    @Override
    public void delete(DigitalOutput persistent) {
        digitalOutputDAO.delete(persistent);
    }

    @Override
    public void deleteById(Long id) {
        digitalOutputDAO.deleteById(id);
    }

    @Override
    public DigitalOutput getById(Long id) {
        return digitalOutputDAO.getById(id);
    }

    @Override
    public List<DigitalOutput> getAll() {
        return digitalOutputDAO.getAll();
    }


    @Override
    public List<DigitalOutput> getByAPCSObjectId(Long id) {
        return digitalOutputDAO.getByAPCSObjectId(id);
    }

    @Override
    public DigitalOutput getByName(String name) {
        return digitalOutputDAO.getByName(name);
    }

    @Override
    public DigitalOutput getBySymbol(String symbol) {
        return digitalOutputDAO.getBySymbol(symbol);
    }

    @Override
    public List<DigitalOutput> getByAPCSObjectName(String name) {
        return digitalOutputDAO.getByAPCSObjectName(name);
    }
}
