package rl.signaltable.core.dao;

import rl.signaltable.core.entity.Role;

import java.util.List;

public interface RoleDao extends GeneralDao<Role> {

    List<Role> findByUsername(String username);
}
