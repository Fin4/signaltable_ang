package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.ProcessControlObjectDao;
import rldev.signaltable.entity.ProcessControlObject;
import rldev.signaltable.service.ProcessControlObjectService;

import java.util.List;

@Service("processControlObjectService")
public class ProcessControlObjectServiceImpl implements ProcessControlObjectService {

    @Autowired
    private ProcessControlObjectDao processControlObjectDao;

    public void save(ProcessControlObject persistent) {
        processControlObjectDao.save(persistent);
    }

    
    public void update(ProcessControlObject persistent) {
        processControlObjectDao.update(persistent);
    }

    
    public void delete(ProcessControlObject persistent) {
        processControlObjectDao.delete(persistent);
    }

    
    public void deleteById(Long id) {
        processControlObjectDao.deleteById(id);
    }


    public ProcessControlObject getById(Long id) {
        return processControlObjectDao.getById(id);
    }

    
    public ProcessControlObject getByName(String name) {
        return processControlObjectDao.getByName(name);
    }

    
    public List<ProcessControlObject> getAll() {
        return processControlObjectDao.getAll();
    }

    public List<ProcessControlObject> getByDepartmentName(String name) {
        return processControlObjectDao.getByDepartmentName(name);
    }

    public List<ProcessControlObject> getByDepartmentId(Long id) {
        return processControlObjectDao.getByDepartmentId(id);
    }

    public ProcessControlObject getBySymbol(String symbol) {
        return processControlObjectDao.getBySymbol(symbol);
    }


}
