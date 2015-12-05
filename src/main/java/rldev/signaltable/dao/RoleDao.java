package rldev.signaltable.dao;

import rldev.signaltable.entity.Role;

import java.util.List;

public interface RoleDao extends GeneralDao<Role> {

    List<Role> findByUsername(String username);
}
