package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rldev.signaltable.dao.AbstractDAO;
import rldev.signaltable.dao.DigitalOutputDAO;
import rldev.signaltable.entity.DigitalOutput;

import java.util.List;

@Repository("digitalOutputDAO")
public class DigitalOutputDAOImpl extends AbstractDAO<DigitalOutput> implements DigitalOutputDAO {

    @Override
    public void save(DigitalOutput persistent) {
        getSessionFactory().save(persistent);
    }

    @Override
    public void update(DigitalOutput persistent) {
        getSessionFactory().update(persistent);
    }

    @Override
    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    @Override
    public void delete(DigitalOutput persistent) {
        getSessionFactory().delete(persistent);
    }

    @Override
    public DigitalOutput getById(Long id) {
        return (DigitalOutput) getSessionFactory().get(DigitalOutput.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DigitalOutput> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.DigitalOutput").list();
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<DigitalOutput> getByAPCSObjectId(Long id) {
        String hql = "from DigitalOutput as do where do.apcsObject.id = :id";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }

    @Override
    public DigitalOutput getByName(String name) {
        return null;
    }

    @Override
    public DigitalOutput getBySymbol(String symbol) {
        String hql = "from DigitalOutput as do where do.symbol = :symbol";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("symbol", symbol);
        return (DigitalOutput) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<DigitalOutput> getByAPCSObjectName(String name) {
        String hql = "from DigitalOutput as do where do.apcsObject.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
}
