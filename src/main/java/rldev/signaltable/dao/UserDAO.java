package rldev.signaltable.dao;

import rldev.signaltable.entity.User;

public interface UserDao extends GeneralDao<User> {

    User findByUsername(String username);
}
