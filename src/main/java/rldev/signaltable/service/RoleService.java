package rldev.signaltable.service;

import rldev.signaltable.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByUsername(String username);

}
