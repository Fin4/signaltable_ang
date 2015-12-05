package rldev.signaltable.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.AbstractDao;
import rldev.signaltable.dao.RoleDao;
import rldev.signaltable.entity.Role;

import java.util.List;

@Repository("roleDao")
@Transactional
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

    @SuppressWarnings("unchecked")
    public List<Role> findByUsername(String username) {
        String query = "select roles from rldev.signaltable.entity.Role roles join roles.users users" +
                " where users.username = :username";
        return getSessionFactory().createQuery(query).setParameter("username", username).list();
    }

    public void save(Role persistent) {
        getSessionFactory().save(persistent);
    }

    public void update(Role persistent) {
        getSessionFactory().update(persistent);
    }

    public void deleteById(Long id) {
        getSessionFactory().delete(getById(id));
    }

    public void delete(Role persistent) {
        getSessionFactory().delete(persistent);
    }

    public Role getById(Long id) {
        return (Role)getSessionFactory().get(Role.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Role> getAll() {
        return getSessionFactory().createQuery("from rldev.signaltable.entity.Role").list();
    }
}
