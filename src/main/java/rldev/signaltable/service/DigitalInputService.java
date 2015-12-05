package rldev.signaltable.service;

import rldev.signaltable.entity.DigitalInput;

import java.util.List;

public interface DigitalInputService extends GeneralEntityService<DigitalInput> {

    List<DigitalInput> getByProcessControlObjectId(Long id);

    DigitalInput getBySymbol(String symbol);

    List<DigitalInput> getByProcessControlObjectName(String name);
}
