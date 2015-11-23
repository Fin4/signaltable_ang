package rldev.signaltable.service;

import rldev.signaltable.entity.Direction;

public interface DirectionService extends GeneralEntityService<Direction> {

    Direction getDirectionByName(String name);
}
