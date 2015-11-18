package rldev.signaltable.service;

import rldev.signaltable.entity.Persistent;

import java.util.List;

public interface GeneralEntityService<T extends Persistent> {

    void save(T persistent);

    void update(T persistent);

    void delete(T persistent);

    void deleteById(Long id);

    T getById(Long id);

    T getByName(String name);

    List<T> getAll();
}
