package rl.signaltable.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {

    @Autowired private SessionFactory sessionFactory;

    public Session getSessionFactory() {
        return sessionFactory.getCurrentSession();
    }
}
