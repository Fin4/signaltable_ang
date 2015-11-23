package rldev.signaltable.service;

import rldev.signaltable.entity.User;

public interface UserService extends GeneralEntityService<User> {

    User findByUsername(String username);
}
