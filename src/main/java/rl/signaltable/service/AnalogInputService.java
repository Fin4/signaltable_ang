package rl.signaltable.service;

import rl.signaltable.core.entity.AnalogInput;

import java.util.List;

public interface AnalogInputService extends GeneralEntityService<AnalogInput> {

    List<AnalogInput> getByProcessControlObjectId(Long id);

    AnalogInput getBySymbol(String symbol);

    List<AnalogInput> getByProcessControlObjectName(String name);
}
