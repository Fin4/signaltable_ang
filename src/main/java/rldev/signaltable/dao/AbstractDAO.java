package rldev.signaltable.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import rldev.signaltable.entity.Persistent;

public abstract class AbstractDAO<T extends Persistent> {

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }
}
