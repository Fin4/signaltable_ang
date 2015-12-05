package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.DepartmentDao;
import rldev.signaltable.entity.Department;
import rldev.signaltable.service.DepartmentService;

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
