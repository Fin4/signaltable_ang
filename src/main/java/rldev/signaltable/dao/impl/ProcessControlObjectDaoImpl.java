package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.ProcessControlObjectDao;
import rldev.signaltable.dao.AbstractDao;
import rldev.signaltable.entity.ProcessControlObject;

import java.util.List;

@Repository("processControlObjectDao")
@Transactional
public class ProcessControlObjectDaoImpl extends AbstractDao<ProcessControlObject> implements ProcessControlObjectDao {

    public void save(ProcessControlObject persistent) {
        getSessionFactory().save(persistent);
    }
    
    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public void update(ProcessControlObject persistent) {
        getSessionFactory().update(persistent);
    }

    public void delete(ProcessControlObject persistent) {
        getSessionFactory().delete(persistent);
    }

    public ProcessControlObject getById(Long id) {
        return (ProcessControlObject) getSessionFactory().get(ProcessControlObject.class, id);
    }

    public ProcessControlObject getByName(String name) {
        String hql = "from ProcessControlObject as obj where obj.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return (ProcessControlObject) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<ProcessControlObject> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.ProcessControlObject").list();
    }

    public ProcessControlObject getBySymbol(String symbol) {
        String hql = "from rldev.signaltable.entity.ProcessControlObject obj where obj.symbol = :symbol";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("symbol", symbol);
        return (ProcessControlObject) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<ProcessControlObject> getByDepartmentName(String sName) {
        String hql = "from rldev.signaltable.entity.ProcessControlObject as a where a.department.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", sName);
        return query.list();
    }
    
    @SuppressWarnings("unchecked")
    public List<ProcessControlObject> getByDepartmentId(Long id) {
        String hql = "from rldev.signaltable.entity.ProcessControlObject as a where a.department.id = :id";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }
}
