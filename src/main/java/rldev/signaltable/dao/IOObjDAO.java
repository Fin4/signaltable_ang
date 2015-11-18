package rldev.signaltable.dao;

import rldev.signaltable.entity.IOObject;

import java.util.List;

public interface IOObjDAO<T extends IOObject> {

    //T getByName(String name);

    T getBySymbol(String symbol);

    List<T> getByAPCSObjectName(String name);

    List<T> getByAPCSObjectId(Long id);
}
