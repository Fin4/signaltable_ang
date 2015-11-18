package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rldev.signaltable.dao.AbstractDAO;
import rldev.signaltable.dao.AnalogInputDAO;
import rldev.signaltable.entity.AnalogInput;

import java.util.List;

@Repository("analogInputDAO")
public class AnalogInputDAOImpl extends AbstractDAO<AnalogInput> implements AnalogInputDAO {

    @Override
    public void delete(AnalogInput persistent) {
        getSessionFactory().delete(persistent);
    }

    @Override
    public void save(AnalogInput persistent) {
        getSessionFactory().save(persistent);
    }

    @Override
    public void update(AnalogInput persistent) {
        getSessionFactory().update(persistent);
    }

    @Override
    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    @Override
    public AnalogInput getById(Long id) {
        return (AnalogInput) getSessionFactory().get(AnalogInput.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AnalogInput> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.AnalogInput").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AnalogInput> getByAPCSObjectId(Long id) {
        String hql = "from rldev.signaltable.entity.AnalogInput as ai where ai.apcsObject.id = :id";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }

    public AnalogInput getByName(String name) {
        return null;
    }

    public AnalogInput getBySymbol(String symbol) {
        String hql = "from AnalogInput as ai where ai.symbol = :symbol";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("symbol", symbol);
        return (AnalogInput) query.uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AnalogInput> getByAPCSObjectName(String name) {
        String hql = "from rldev.signaltable.entity.AnalogInput as ai where ai.apcsObject.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
}
