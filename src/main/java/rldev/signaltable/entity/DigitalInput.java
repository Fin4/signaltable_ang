package rldev.signaltable.entity;

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

    /*@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DigitalInput)) {
            return false;
        }
        DigitalInput di = (DigitalInput) obj;
        return this.getId().equals(di.getId()) && this.getSymbol().equals(di.getSymbol());
    }*/
}
