package rldev.signaltable.entity;

import javax.persistence.*;

@Entity
@Table(name = "DIGITALINPUT")
public class DigitalInput extends IOObject {

    public DigitalInput() {}

    public DigitalInput(String symbol, String description, APCSObject apcsObject) {
        super(symbol, description, apcsObject);
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
