package rldev.signaltable.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DIGITALOUTPUT")
public class DigitalOutput extends IOObject {

    public DigitalOutput() {}

    public DigitalOutput(String symbol, String description, APCSObject apcsObject) {
        super(symbol, description, apcsObject);
    }
}