package rldev.signaltable.service;

import rldev.signaltable.entity.APCSObject;

import java.util.List;

public interface APCSObjectService extends GeneralEntityService<APCSObject> {

    List<APCSObject> getByDirectionName(String name);

    List<APCSObject> getByDirectionId(Long id);

    APCSObject getBySymbol(String symbol);

    APCSObject getByName(String name);
}
