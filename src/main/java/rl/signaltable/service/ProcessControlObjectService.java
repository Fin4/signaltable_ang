package rl.signaltable.service;

import rl.signaltable.core.entity.ProcessControlObject;

import java.util.List;

public interface ProcessControlObjectService extends GeneralEntityService<ProcessControlObject> {

    List<ProcessControlObject> getByDepartmentName(String name);

    List<ProcessControlObject> getByDepartmentId(Long id);

    ProcessControlObject getBySymbol(String symbol);

    ProcessControlObject getByName(String name);
}
