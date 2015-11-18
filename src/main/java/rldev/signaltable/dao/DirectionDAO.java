package rldev.signaltable.dao;

import rldev.signaltable.entity.APCSObject;
import rldev.signaltable.entity.Direction;

import java.util.List;
import java.util.Set;

/**
 * Created by operator on 02.03.2015.
 */
public interface DirectionDAO extends GeneralDAO<Direction> {
    public Direction getDirectionByName(String name);
}
