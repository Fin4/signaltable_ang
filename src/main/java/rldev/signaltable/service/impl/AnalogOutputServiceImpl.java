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

    public void save(AnalogOutput persistent) {
        analogOutputDAO.save(persistent);
    }


    public void update(AnalogOutput persistent) {
        analogOutputDAO.update(persistent);
    }


    public void delete(AnalogOutput persistent) {
        analogOutputDAO.delete(persistent);
    }


    public void deleteById(Long id) {
        analogOutputDAO.deleteById(id);
    }


    public AnalogOutput getById(Long id) {
        return analogOutputDAO.getById(id);
    }


    public List<AnalogOutput> getAll() {
        return analogOutputDAO.getAll();
    }


    public List<AnalogOutput> getByAPCSObjectId(Long id) {
        return analogOutputDAO.getByAPCSObjectId(id);
    }


    public AnalogOutput getBySymbol(String symbol) {
        return analogOutputDAO.getBySymbol(symbol);
    }


    public List<AnalogOutput> getByAPCSObjectName(String name) {
        return analogOutputDAO.getByAPCSObjectName(name);
    }
}
