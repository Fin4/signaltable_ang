package rl.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rl.signaltable.core.dao.DepartmentDao;
import rl.signaltable.service.DepartmentService;
import rl.signaltable.core.entity.Department;

import java.util.List;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired private DepartmentDao departmentDao;

    public void save(Department persistent) {
        departmentDao.save(persistent);
    }

    public void update(Department persistent) {
        departmentDao.update(persistent);
    }

    public void delete(Department persistent) {
        departmentDao.delete(persistent);
    }

    public void deleteById(Long id) {
        departmentDao.deleteById(id);
    }

    public Department getById(Long id) {
        return departmentDao.getById(id);
    }

    public List<Department> getAll() {
        return departmentDao.getAll();
    }

    public Department getByName(String name) {
        return departmentDao.getByName(name);
    }
}
