package rl.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rl.signaltable.core.dao.RoleDao;
import rl.signaltable.core.entity.Role;
import rl.signaltable.service.RoleService;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    public List<Role> findByUsername(String username) {
        return roleDao.findByUsername(username);
    }
}
