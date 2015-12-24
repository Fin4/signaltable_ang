package rl.signaltable.service;

import rl.signaltable.core.entity.DigitalOutput;

import java.util.List;

public interface DigitalOutputService extends GeneralEntityService<DigitalOutput> {

    List<DigitalOutput> getByProcessControlObjectId(Long id);

    DigitalOutput getBySymbol(String symbol);

    List<DigitalOutput> getByProcessControlObjectName(String name);
}
