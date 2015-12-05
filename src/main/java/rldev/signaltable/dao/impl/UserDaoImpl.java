package rldev.signaltable.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AbstractDao;
import rldev.signaltable.dao.UserDao;
import rldev.signaltable.entity.User;

import java.util.List;

@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public void save(User persistent) {
        getSessionFactory().save(persistent);
    }

    public void update(User persistent) {
        getSessionFactory().update(persistent);
    }

    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public void delete(User persistent) {
        getSessionFactory().delete(persistent);
    }

    public User getById(Long id) {
        return (User)getSessionFactory().get(User.class, id);
    }
    @SuppressWarnings("unchecked")
    public List<User> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.User").list();
    }

    public User findByUsername(String username) {
        String query = "from rldev.signaltable.entity.User as user where user.username = :username";
        return (User) getSessionFactory().createQuery(query).setParameter("username", username).uniqueResult();
    }
}
