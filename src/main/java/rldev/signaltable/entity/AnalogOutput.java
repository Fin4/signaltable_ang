package rldev.signaltable.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ANALOGOUTPUT")
public class AnalogOutput extends IOObject {

    public AnalogOutput() {}

    public AnalogOutput(String symbol, String description, APCSObject apcsObject) {
        super(symbol, description, apcsObject);
    }
}
