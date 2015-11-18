package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import rldev.signaltable.dao.APCSObjectDAO;
import rldev.signaltable.dao.AbstractDAO;
import rldev.signaltable.entity.APCSObject;

import java.util.List;

@Repository("apcsObjectDAO")
public class APCSObjectDAOImpl extends AbstractDAO<APCSObject> implements APCSObjectDAO {

    
    public void save(APCSObject persistent) {
        getSessionFactory().save(persistent);
    }

    
    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    
    public void update(APCSObject persistent) {
        getSessionFactory().update(persistent);
    }

    
    public void delete(APCSObject persistent) {
        getSessionFactory().delete(persistent);
    }

    
    public APCSObject getById(Long id) {
        return (APCSObject) getSessionFactory().get(APCSObject.class, id);
    }

    
    public APCSObject getByName(String name) {
        String hql = "from APCSObject as obj where obj.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return (APCSObject) query.uniqueResult();
    }

    
    @SuppressWarnings("unchecked")
    public List<APCSObject> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.APCSObject").list();
    }

    
    public APCSObject getApcsObjectBySymbol(String symbol) {
        String hql = "from rldev.signaltable.entity.APCSObject obj where obj.symbol = :symbol";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("symbol", symbol);
        return (APCSObject) query.uniqueResult();
    }

    
    @SuppressWarnings("unchecked")
    public List<APCSObject> getAllObjectsByDirectionName(String sName) {
        String hql = "from rldev.signaltable.entity.APCSObject as a where a.direction.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", sName);
        return query.list();
    }

    
    @SuppressWarnings("unchecked")
    public List<APCSObject> getAllObjectsByDirectionId(Long id) {
        String hql = "from rldev.signaltable.entity.APCSObject as a where a.direction.id = :id";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("id", id);
        return query.list();
    }
}
