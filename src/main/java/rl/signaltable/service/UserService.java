package rl.signaltable.service;

import rl.signaltable.core.entity.User;

public interface UserService extends GeneralEntityService<User> {

    User findByUsername(String username);
}
