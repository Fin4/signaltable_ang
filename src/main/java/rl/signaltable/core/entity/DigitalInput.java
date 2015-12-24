package rl.signaltable.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "digitalinput")
public class DigitalInput extends IoUnit {

    public DigitalInput() {}

    public DigitalInput(String symbol, String description, ProcessControlObject processControlObject) {
        super(symbol, description, processControlObject);
    }

    @Override
    public String toString() {
        return symbol + " " + description;
    }

}
