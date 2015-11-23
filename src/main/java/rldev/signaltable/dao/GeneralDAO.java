package rldev.signaltable.dao;

import rldev.signaltable.entity.Persistent;

import java.util.List;

public interface GeneralDAO<T extends Persistent> {

    void save(T persistent);

    void update(T persistent);

    void deleteById(Long id);

    void delete(T persistent);

    T getById(Long id);

    List<T> getAll();
}
