package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rldev.signaltable.dao.UserDao;
import rldev.signaltable.entity.User;
import rldev.signaltable.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired private UserDao userDao;

    public void save(User persistent) {
        userDao.save(persistent);
    }

    public void update(User persistent) {
        userDao.save(persistent);
    }

    public void delete(User persistent) {
        userDao.delete(persistent);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    public User getById(Long id) {
        return userDao.getById(id);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
