package rldev.signaltable.dao;

import rldev.signaltable.entity.APCSObject;

import java.util.List;

public interface APCSObjectDAO extends GeneralDAO<APCSObject> {

    APCSObject getApcsObjectBySymbol(String symbol);

    List<APCSObject> getAllObjectsByDirectionName(String name);

    List<APCSObject> getAllObjectsByDirectionId(Long id);
}
