package rldev.signaltable.dao;

import rldev.signaltable.entity.Direction;

public interface DirectionDAO extends GeneralDAO<Direction> {
    Direction getByName(String name);
}
