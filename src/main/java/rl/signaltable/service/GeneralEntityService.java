package rl.signaltable.service;

import java.util.List;

public interface GeneralEntityService<T> {

    void save(T persistent);

    void update(T persistent);

    void delete(T persistent);

    void deleteById(Long id);

    T getById(Long id);

    List<T> getAll();
}
