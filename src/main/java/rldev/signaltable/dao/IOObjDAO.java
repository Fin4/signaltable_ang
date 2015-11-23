package rldev.signaltable.dao;

import rldev.signaltable.entity.IOObject;

import java.util.List;

public interface IOObjDAO<T extends IOObject> {

    T getBySymbol(String symbol);

    List<T> getByAPCSObjectName(String name);

    List<T> getByAPCSObjectId(Long id);
}
