package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rldev.signaltable.dao.DirectionDAO;
import rldev.signaltable.entity.Direction;
import rldev.signaltable.service.DirectionService;

import java.util.List;

@Service("directionService")
@Transactional
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionDAO directionDAO;

    @Override
    public void save(Direction persistent) {
        directionDAO.save(persistent);
    }

    @Override
    public void update(Direction persistent) {
        directionDAO.update(persistent);
    }

    @Override
    public void delete(Direction persistent) {
        directionDAO.delete(persistent);
    }

    @Override
    public void deleteById(Long id) {
        directionDAO.deleteById(id);
    }

    @Override
    public Direction getById(Long id) {
        return directionDAO.getById(id);
    }

    @Override
    public Direction getByName(String name) {
        return directionDAO.getByName(name);
    }

    @Override
    public List<Direction> getAll() {
        return directionDAO.getAll();
    }

    @Override
    public Direction getDirectionByName(String name) {
        return directionDAO.getDirectionByName(name);
    }
}
