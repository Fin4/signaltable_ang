package rl.signaltable.core.dao;

import rl.signaltable.core.entity.Department;

public interface DepartmentDao extends GeneralDao<Department> {
    Department getByName(String name);
}
