package rldev.signaltable.service;

import rldev.signaltable.entity.AnalogInput;

import java.util.List;

public interface AnalogInputService extends GeneralEntityService<AnalogInput> {

    List<AnalogInput> getByAPCSObjectId(Long id);

    AnalogInput getByName(String name);

    AnalogInput getBySymbol(String symbol);

    List<AnalogInput> getByAPCSObjectName(String name);
}
