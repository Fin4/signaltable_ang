package rldev.signaltable.dao;

import rldev.signaltable.entity.Department;

public interface DepartmentDao extends GeneralDao<Department> {
    Department getByName(String name);
}
