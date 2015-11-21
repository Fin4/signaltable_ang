package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rldev.signaltable.dao.AbstractDAO;
import rldev.signaltable.dao.AnalogOutputDAO;
import rldev.signaltable.entity.AnalogOutput;

import java.util.List;

@Repository("analogOutputDAO")
public class AnalogOutputDAOImpl extends AbstractDAO<AnalogOutput> implements AnalogOutputDAO {

    
    public void save(AnalogOutput persistent) {
        getSessionFactory().save(persistent);
    }

    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public void update(AnalogOutput persistent) {
        getSessionFactory().update(persistent);
    }

    public void delete(AnalogOutput persistent) {
        getSessionFactory().delete(persistent);
    }

    public AnalogOutput getById(Long id) {
        return (AnalogOutput) getSessionFactory().get(AnalogOutput.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<AnalogOutput> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.AnalogOutput").list();
    }

    @SuppressWarnings("unchecked")
    public List<AnalogOutput> getByAPCSObjectId(Long id) {
        String hql = "from AnalogOutput as ao where ao.apcsObject.id = :id";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }

    public AnalogOutput getByName(String name) {
        return null;
    }

    public AnalogOutput getBySymbol(String symbol) {
        String hql = "from rldev.signaltable.entity.AnalogOutput as ao where ao.symbol = :symbol";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("symbol", symbol);
        return (AnalogOutput) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<AnalogOutput> getByAPCSObjectName(String name) {
        String hql = "from rldev.signaltable.entity.AnalogOutput as ao where ao.apcsObject.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
}
