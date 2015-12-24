package rl.signaltable.core.dao;

import rl.signaltable.core.entity.IoUnit;

import java.util.List;

public interface IoUnitDao<T extends IoUnit> {

    T getBySymbol(String symbol);

    List<T> getByPcObjectName(String name);

    List<T> getByPcObjectId(Long id);
}
