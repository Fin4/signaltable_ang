package rldev.signaltable.service;

import rldev.signaltable.entity.APCSObject;

import java.util.List;

public interface APCSObjectService extends GeneralEntityService<APCSObject> {

    List<APCSObject> getAllObjectsByDirectionName(String name);

    List<APCSObject> getAllObjectsByDirectionId(Long id);

    APCSObject getApcsObjectBySymbol(String symbol);
}
