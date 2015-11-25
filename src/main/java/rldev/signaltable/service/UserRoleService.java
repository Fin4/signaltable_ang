package rldev.signaltable.service;

import rldev.signaltable.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    List<UserRole> findByUsername(String username);
}
