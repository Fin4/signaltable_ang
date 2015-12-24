package rl.signaltable.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "analogoutput")
public class AnalogOutput extends IoUnit {

    public AnalogOutput() {}

    public AnalogOutput(String symbol, String description, ProcessControlObject processControlObject) {
        super(symbol, description, processControlObject);
    }
}
