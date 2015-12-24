package rl.signaltable.service;

import rl.signaltable.core.entity.Department;

public interface DepartmentService extends GeneralEntityService<Department> {

    Department getByName(String name);
}
