package rldev.signaltable.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "analoginput")
public class AnalogInput extends IoUnit {

    public AnalogInput() {}

    public AnalogInput(String symbol, String description, ProcessControlObject processControlObject) {
        super(symbol, description, processControlObject);
    }

    @Override
    public String toString() {
        return getSymbol() + " " + getDescription();
    }
}
