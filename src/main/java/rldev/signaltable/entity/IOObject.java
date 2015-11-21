package rldev.signaltable.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class IOObject implements Persistent {

    protected Long id;
    protected String symbol;
    protected String description;

    protected APCSObject apcsObject;

    @Id
    @GeneratedValue(generator="increment")
    //@GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "symbol", nullable = false, unique = true)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "fk_apcsobject_id", nullable = false, insertable = true)
    public APCSObject getApcsObject() {
        return apcsObject;
    }

    public void setApcsObject(APCSObject apcsObject) {
        this.apcsObject = apcsObject;
        //symbol = apcsObject.getSymbol() + "_" + symbol;
    }

    protected IOObject() {}

    protected IOObject(String symbol, String description, APCSObject apcsObject) {
        this.symbol = symbol;
        this.description = description;
        this.apcsObject = apcsObject;
    }

    @Override
    public String toString() {
        return symbol + " " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IOObject)) return false;

        IOObject ioObject = (IOObject) o;

        if (getSymbol() != null ? !getSymbol().equals(ioObject.getSymbol()) : ioObject.getSymbol() != null)
            return false;
        return !(getApcsObject() != null ? !getApcsObject().equals(ioObject.getApcsObject()) : ioObject.getApcsObject() != null);

    }

    @Override
    public int hashCode() {
        int result = getSymbol() != null ? getSymbol().hashCode() : 0;
        result = 31 * result + (getApcsObject() != null ? getApcsObject().hashCode() : 0);
        return result;
    }
}
