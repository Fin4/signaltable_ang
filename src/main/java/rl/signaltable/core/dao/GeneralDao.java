package rl.signaltable.core.dao;

import java.util.List;

public interface GeneralDao<T> {

    void save(T persistent);

    void update(T persistent);

    void deleteById(Long id);

    void delete(T persistent);

    T getById(Long id);

    List<T> getAll();
}
