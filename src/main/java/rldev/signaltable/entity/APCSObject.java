package rldev.signaltable.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "APCSOBJECT")
public class APCSObject implements Persistent {

    private Long id;
    private String symbol;
    private String name;
    private String description;

    private Direction direction;

    private List<DigitalInput> digitalInputList;
    private List<AnalogInput> analogInputList;
    private List<DigitalOutput> digitalOutputList;
    private List<AnalogOutput> analogOutputList;


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "fk_direction_id", nullable = false)
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }



    @OneToMany(mappedBy = "apcsObject", fetch = FetchType.LAZY)
    public List<AnalogInput> getAnalogInputList() {
        return analogInputList;
    }

    public void setAnalogInputList(List<AnalogInput> analogInputList) {
        this.analogInputList = analogInputList;
    }

    @OneToMany(mappedBy = "apcsObject", fetch = FetchType.LAZY)
    public List<DigitalInput> getDigitalInputList() {
        return digitalInputList;
    }

    public void setDigitalInputList(List<DigitalInput> digitalInputList) {
        this.digitalInputList = digitalInputList;
    }

    @OneToMany(mappedBy = "apcsObject", fetch = FetchType.LAZY)
    public List<AnalogOutput> getAnalogOutputList() {
        return analogOutputList;
    }

    public void setAnalogOutputList(List<AnalogOutput> analogOutputList) {
        this.analogOutputList = analogOutputList;
    }

    @OneToMany(mappedBy = "apcsObject", fetch = FetchType.LAZY)
    public List<DigitalOutput> getDigitalOutputList() {
        return digitalOutputList;
    }

    public void setDigitalOutputList(List<DigitalOutput> digitalOutputList) {
        this.digitalOutputList = digitalOutputList;
    }

    @Override
    public String toString() {
        return getSymbol() + " " + getName() + " " + getDescription();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof APCSObject)) {
            return false;
        }

        final APCSObject apcsObject = (APCSObject) obj;
        return this.getId().equals(apcsObject.getId()) && this.getSymbol().equals(apcsObject.getSymbol());
    }
}
