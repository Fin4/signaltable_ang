package rldev.signaltable.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ANALOGINPUT")
public class AnalogInput extends IOObject {

    public AnalogInput() {}

    public AnalogInput(String symbol, String description, APCSObject apcsObject) {
        super(symbol, description, apcsObject);
    }

    @Override
    public String toString() {
        return getSymbol() + " " + getDescription();
    }
}
