package rldev.signaltable.dao;

import rldev.signaltable.entity.IoUnit;

import java.util.List;

public interface IoUnitDao<T extends IoUnit> {

    T getBySymbol(String symbol);

    List<T> getByProcessControlObjectName(String name);

    List<T> getByProcessControlObjectId(Long id);
}
