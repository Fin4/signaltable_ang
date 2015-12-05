package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AbstractDao;
import rldev.signaltable.dao.DepartmentDao;
import rldev.signaltable.entity.Department;

import java.util.List;

@Repository("departmentDao")
@Transactional
public class DepartmentDaoImpl extends AbstractDao<Department> implements DepartmentDao {
    
    public void delete(Department persistent) {
        getSessionFactory().delete(persistent);
    }

    public void update(Department persistent) {
        getSessionFactory().update(persistent);
    }

    public void save(Department persistent) {
        getSessionFactory().save(persistent);
    }

    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public Department getById(Long id) {
        return (Department) getSessionFactory().get(Department.class, id);
    }

    public Department getByName(String name) {
        String hql = "from Department as d where d.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return (Department) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.Department").list();
    }
}
