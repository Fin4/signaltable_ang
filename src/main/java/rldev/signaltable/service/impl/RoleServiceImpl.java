package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rldev.signaltable.dao.RoleDao;
import rldev.signaltable.entity.Role;
import rldev.signaltable.service.RoleService;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    public List<Role> findByUsername(String username) {
        return roleDao.findByUsername(username);
    }
}
