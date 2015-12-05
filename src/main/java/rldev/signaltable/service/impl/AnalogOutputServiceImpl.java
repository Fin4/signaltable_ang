package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AnalogOutputDao;
import rldev.signaltable.entity.AnalogOutput;
import rldev.signaltable.service.AnalogOutputService;

import java.util.List;

@Service("analogOutputService")
public class AnalogOutputServiceImpl implements AnalogOutputService {

    @Autowired
    private AnalogOutputDao analogOutputDao;

    public void save(AnalogOutput persistent) {
        analogOutputDao.save(persistent);
    }


    public void update(AnalogOutput persistent) {
        analogOutputDao.update(persistent);
    }


    public void delete(AnalogOutput persistent) {
        analogOutputDao.delete(persistent);
    }


    public void deleteById(Long id) {
        analogOutputDao.deleteById(id);
    }


    public AnalogOutput getById(Long id) {
        return analogOutputDao.getById(id);
    }


    public List<AnalogOutput> getAll() {
        return analogOutputDao.getAll();
    }


    public List<AnalogOutput> getByProcessControlObjectId(Long id) {
        return analogOutputDao.getByProcessControlObjectId(id);
    }


    public AnalogOutput getBySymbol(String symbol) {
        return analogOutputDao.getBySymbol(symbol);
    }


    public List<AnalogOutput> getByProcessControlObjectName(String name) {
        return analogOutputDao.getByProcessControlObjectName(name);
    }
}
