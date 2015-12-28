package rl.signaltable.persistence;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rl.signaltable.core.dao.AnalogInputDao;
import rl.signaltable.core.entity.AnalogInput;

import java.util.List;

@Repository
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
        return getSessionFactory().createQuery("from rl.signaltable.core.entity.AnalogInput").list();
    }

    @SuppressWarnings("unchecked")
    public List<AnalogInput> getByPcObjectId(Long id) {
        String hql = "from rl.signaltable.core.entity.AnalogInput as ai where ai.processControlObject.id = :id";
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
    public List<AnalogInput> getByPcObjectName(String name) {
        String hql = "from rl.signaltable.core.entity.AnalogInput as ai where ai.processControlObject.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return query.list();
    }
}
