package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AbstractDao;
import rldev.signaltable.dao.AnalogInputDao;
import rldev.signaltable.entity.AnalogInput;

import java.util.List;

@Repository("analogInputDao")
@Transactional
public class AnalogInputDaoImpl extends AbstractDao<AnalogInput> implements AnalogInputDao {

    public void delete(AnalogInput persistent) {
        getSessionFactory().delete(persistent);
    }

    public void save(AnalogInput persistent) {
        getSessionFactory().save(persistent);
    }

    public void update(AnalogInput persistent) {
        getSessionFactory().update(persistent);
    }

    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public AnalogInput getById(Long id) {
        return (AnalogInput) getSessionFactory().get(AnalogInput.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<AnalogInput> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.AnalogInput").list();
    }

    @SuppressWarnings("unchecked")
    public List<AnalogInput> getByProcessControlObjectId(Long id) {
        String hql = "from rldev.signaltable.entity.AnalogInput as ai where ai.processControlObject.id = :id";
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

    @SuppressWarnings("unchecked")
    public List<AnalogInput> getByProcessControlObjectName(String name) {
        String hql = "from rldev.signaltable.entity.AnalogInput as ai where ai.processControlObject.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
}
