package rldev.signaltable.dao;

import rldev.signaltable.entity.APCSObject;

import java.util.List;

public interface APCSObjectDAO extends GeneralDAO<APCSObject> {

    APCSObject getByName(String name);

    APCSObject getBySymbol(String symbol);

    List<APCSObject> getByDirectionName(String name);

    List<APCSObject> getByDirectionId(Long id);
}
