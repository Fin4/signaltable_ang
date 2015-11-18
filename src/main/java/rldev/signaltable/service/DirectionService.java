package rldev.signaltable.service;

import rldev.signaltable.entity.Direction;

public interface DirectionService extends GeneralEntityService<Direction> {

    public Direction getDirectionByName(String name);
}
