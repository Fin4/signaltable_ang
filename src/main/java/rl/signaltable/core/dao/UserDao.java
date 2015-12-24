package rl.signaltable.core.dao;

import rl.signaltable.core.entity.User;

public interface UserDao extends GeneralDao<User> {

    User findByUsername(String username);
}
