package rldev.signaltable.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "digitaloutput")
public class DigitalOutput extends IoUnit {

    public DigitalOutput() {}

    public DigitalOutput(String symbol, String description, ProcessControlObject processControlObject) {
        super(symbol, description, processControlObject);
    }
}