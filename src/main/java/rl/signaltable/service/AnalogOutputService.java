package rl.signaltable.service;

import rl.signaltable.core.entity.AnalogOutput;

import java.util.List;

public interface AnalogOutputService extends GeneralEntityService<AnalogOutput> {

    List<AnalogOutput> getByProcessControlObjectId(Long id);

    AnalogOutput getBySymbol(String symbol);

    List<AnalogOutput> getByProcessControlObjectName(String name);
}
