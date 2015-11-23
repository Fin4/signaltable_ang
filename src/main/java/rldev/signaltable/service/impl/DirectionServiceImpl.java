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

    @Autowired private DirectionDAO directionDAO;

    public void save(Direction persistent) {
        directionDAO.save(persistent);
    }

    public void update(Direction persistent) {
        directionDAO.update(persistent);
    }

    public void delete(Direction persistent) {
        directionDAO.delete(persistent);
    }

    public void deleteById(Long id) {
        directionDAO.deleteById(id);
    }

    public Direction getById(Long id) {
        return directionDAO.getById(id);
    }

    public List<Direction> getAll() {
        return directionDAO.getAll();
    }

    public Direction getDirectionByName(String name) {
        return directionDAO.getByName(name);
    }
}
