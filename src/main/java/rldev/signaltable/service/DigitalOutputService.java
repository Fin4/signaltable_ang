package rldev.signaltable.service;

import rldev.signaltable.entity.DigitalOutput;

import java.util.List;

public interface DigitalOutputService extends GeneralEntityService<DigitalOutput> {

    List<DigitalOutput> getByAPCSObjectId(Long id);

    DigitalOutput getBySymbol(String symbol);

    List<DigitalOutput> getByAPCSObjectName(String name);
}
