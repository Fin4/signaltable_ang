package rldev.signaltable.service;

import rldev.signaltable.entity.AnalogOutput;

import java.util.List;

public interface AnalogOutputService extends GeneralEntityService<AnalogOutput> {

    List<AnalogOutput> getByProcessControlObjectId(Long id);

    AnalogOutput getBySymbol(String symbol);

    List<AnalogOutput> getByProcessControlObjectName(String name);
}
