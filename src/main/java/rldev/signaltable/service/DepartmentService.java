package rldev.signaltable.service;

import rldev.signaltable.entity.Department;

public interface DepartmentService extends GeneralEntityService<Department> {

    Department getByName(String name);
}
