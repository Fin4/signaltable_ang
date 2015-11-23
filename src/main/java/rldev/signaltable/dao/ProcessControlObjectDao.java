package rldev.signaltable.dao;

import rldev.signaltable.entity.ProcessControlObject;

import java.util.List;

public interface ProcessControlObjectDao extends GeneralDao<ProcessControlObject> {

    ProcessControlObject getByName(String name);

    ProcessControlObject getBySymbol(String symbol);

    List<ProcessControlObject> getByDepartmentName(String name);

    List<ProcessControlObject> getByDepartmentId(Long id);
}
