package rl.signaltable.persistence;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rl.signaltable.core.dao.DigitalOutputDao;
import rl.signaltable.core.entity.DigitalOutput;

import java.util.List;

@Repository("digitalOutputDao")
@Transactional
public class DigitalOutputDaoImpl extends AbstractDao<DigitalOutput> implements DigitalOutputDao {

    public void save(DigitalOutput persistent) {
        getSessionFactory().save(persistent);
    }

    public void update(DigitalOutput persistent) {
        getSessionFactory().update(persistent);
    }

    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public void delete(DigitalOutput persistent) {
        getSessionFactory().delete(persistent);
    }

    public DigitalOutput getById(Long id) {
        return (DigitalOutput) getSessionFactory().get(DigitalOutput.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<DigitalOutput> getAll() {
        return getSessionFactory().createQuery("from rl.signaltable.core.entity.DigitalOutput").list();
    }

    @SuppressWarnings("unchecked")
    public List<DigitalOutput> getByPcObjectId(Long id) {
        String hql = "from DigitalOutput as do where do.processControlObject.id = :id";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }

    public DigitalOutput getBySymbol(String symbol) {
        String hql = "from DigitalOutput as do where do.symbol = :symbol";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("symbol", symbol);
        return (DigitalOutput) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<DigitalOutput> getByPcObjectName(String name) {
        String hql = "from DigitalOutput as do where do.processControlObject.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
}
