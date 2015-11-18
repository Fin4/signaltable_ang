package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AnalogOutputDAO;
import rldev.signaltable.entity.AnalogOutput;
import rldev.signaltable.service.AnalogOutputService;

import java.util.List;

@Service("analogOutputService")
@Transactional
public class AnalogOutputServiceImpl implements AnalogOutputService {

    @Autowired
    private AnalogOutputDAO analogOutputDAO;

    @Override
    public void save(AnalogOutput persistent) {
        analogOutputDAO.save(persistent);
    }

    @Override
    public void update(AnalogOutput persistent) {
        analogOutputDAO.update(persistent);
    }

    @Override
    public void delete(AnalogOutput persistent) {
        analogOutputDAO.delete(persistent);
    }

    @Override
    public void deleteById(Long id) {
        analogOutputDAO.deleteById(id);
    }

    @Override
    public AnalogOutput getById(Long id) {
        return analogOutputDAO.getById(id);
    }

    @Override
    public List<AnalogOutput> getAll() {
        return analogOutputDAO.getAll();
    }

    @Override
    public List<AnalogOutput> getByAPCSObjectId(Long id) {
        return analogOutputDAO.getByAPCSObjectId(id);
    }

    @Override
    public AnalogOutput getByName(String name) {
        return analogOutputDAO.getByName(name);
    }

    @Override
    public AnalogOutput getBySymbol(String symbol) {
        return analogOutputDAO.getBySymbol(symbol);
    }

    @Override
    public List<AnalogOutput> getByAPCSObjectName(String name) {
        return analogOutputDAO.getByAPCSObjectName(name);
    }
}
