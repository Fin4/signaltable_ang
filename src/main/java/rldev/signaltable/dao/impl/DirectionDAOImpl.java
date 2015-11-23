package rldev.signaltable.dao.impl;

import org.hibernate.Query;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import rldev.signaltable.dao.AbstractDAO;
import rldev.signaltable.dao.DirectionDAO;
import rldev.signaltable.entity.Direction;

import java.util.List;

@Repository("directionDAO")
public class DirectionDAOImpl extends AbstractDAO<Direction> implements DirectionDAO {
    
    public void delete(Direction persistent) {
        getSessionFactory().delete(persistent);
    }

    public void update(Direction persistent) {
        getSessionFactory().update(persistent);
    }

    public void save(Direction persistent) {
        getSessionFactory().save(persistent);
    }

    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public Direction getById(Long id) {
        return (Direction) getSessionFactory().get(Direction.class, id);
    }

    public Direction getByName(String name) {
        String hql = "from Direction as d where d.name = :name";
        Query query = getSessionFactory().createQuery(hql);
        query.setParameter("name", name);
        return (Direction) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Direction> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.Direction").list();
    }
}
