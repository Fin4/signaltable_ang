package rl.signaltable.persistence;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rl.signaltable.core.dao.AnalogOutputDao;
import rl.signaltable.core.entity.AnalogOutput;

import java.util.List;

@Repository("analogOutputDao")
@Transactional
public class AnalogOutputDaoImpl extends AbstractDao<AnalogOutput> implements AnalogOutputDao {

    
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
        return getSessionFactory().createQuery("from rl.signaltable.core.entity.AnalogOutput").list();
    }

    @SuppressWarnings("unchecked")
    public List<AnalogOutput> getByPcObjectId(Long id) {
        String hql = "from AnalogOutput as ao where ao.processControlObject.id = :id";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }

    public AnalogOutput getBySymbol(String symbol) {
        String hql = "from AnalogOutput as ao where ao.symbol = :symbol";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("symbol", symbol);
        return (AnalogOutput) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<AnalogOutput> getByPcObjectName(String name) {
        String hql = "from AnalogOutput as ao where ao.processControlObject.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
}
