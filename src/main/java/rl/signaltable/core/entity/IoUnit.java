package rl.signaltable.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@MappedSuperclass
public abstract class IoUnit {

    protected Long id;
    protected String symbol;
    protected String description;

    @JsonIgnore/*Properties({"name", "description"})*/
    protected ProcessControlObject processControlObject;

    @Id
    @GeneratedValue
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
    @JoinColumn(name = "pcobject_id", nullable = false, insertable = true)
    public ProcessControlObject getProcessControlObject() {
        return processControlObject;
    }

    public void setProcessControlObject(ProcessControlObject processControlObject) {
        this.processControlObject = processControlObject;
    }

    protected IoUnit() {}

    protected IoUnit(String symbol, String description, ProcessControlObject processControlObject) {
        this.symbol = symbol;
        this.description = description;
        this.processControlObject = processControlObject;
    }

    @Override
    public String toString() {
        return symbol + " " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IoUnit)) return false;

        IoUnit ioUnit = (IoUnit) o;

        if (getSymbol() != null ? !getSymbol().equals(ioUnit.getSymbol()) : ioUnit.getSymbol() != null)
            return false;
        return !(getProcessControlObject() != null ? !getProcessControlObject().equals(ioUnit.getProcessControlObject()) : ioUnit.getProcessControlObject() != null);

    }

    @Override
    public int hashCode() {
        int result = getSymbol() != null ? getSymbol().hashCode() : 0;
        result = 31 * result + (getProcessControlObject() != null ? getProcessControlObject().hashCode() : 0);
        return result;
    }
}
