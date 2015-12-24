package rl.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import rl.signaltable.core.dao.DigitalInputDao;
import rl.signaltable.core.entity.DigitalInput;
import rl.signaltable.service.DigitalInputService;

import java.util.List;

@Service("digitalInputService")
public class DigitalInputServiceImpl implements DigitalInputService {

    @Autowired
    private DigitalInputDao digitalInputDao;

    @PreAuthorize("hasPermission(#di, '')")
    public void save(DigitalInput di) {
        digitalInputDao.save(di);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    public void update(DigitalInput di) {
        digitalInputDao.update(di);
    }

    @PreAuthorize("hasRole('#di.processControlObject.department.name')")
    public void deleteById(Long id) {
        digitalInputDao.deleteById(id);
    }

    @PreAuthorize("hasRole('#di.processControlObject.department.name')")
    public void delete(DigitalInput di) {
        digitalInputDao.delete(di);
    }

    public DigitalInput getById(Long id) {
        return digitalInputDao.getById(id);
    }

    public List getAll() {
        return digitalInputDao.getAll();
    }

    
    public List<DigitalInput> getByProcessControlObjectId(Long id) {
        return digitalInputDao.getByPcObjectId(id);
    }
    
    public DigitalInput getBySymbol(String symbol) {
        return digitalInputDao.getBySymbol(symbol);
    }

    public List<DigitalInput> getByProcessControlObjectName(String name) {
        return digitalInputDao.getByPcObjectName(name);
    }
}
