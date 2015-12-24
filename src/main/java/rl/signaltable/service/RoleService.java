package rl.signaltable.service;

import rl.signaltable.core.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByUsername(String username);

}
