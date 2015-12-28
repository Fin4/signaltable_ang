package rl.signaltable.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pcobject")
public class ProcessControlObject {

    private Long id;
    private String symbol;
    private String name;
    private String description;

    @JsonIgnoreProperties({"description"})
    private Department department;

    @JsonIgnore private List<DigitalInput> digitalInputs;
    @JsonIgnore private List<AnalogInput> analogInputs;
    @JsonIgnore private List<DigitalOutput> digitalOutputs;
    @JsonIgnore private List<AnalogOutput> analogOutputs;

    @Id
    @GeneratedValue
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
    @JoinColumn(name = "department_id", nullable = false)
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "processControlObject", fetch = FetchType.LAZY)
    public List<AnalogInput> getAnalogInputs() {
        return analogInputs;
    }

    public void setAnalogInputs(List<AnalogInput> analogInputList) {
        this.analogInputs = analogInputList;
    }

    @OneToMany(mappedBy = "processControlObject", fetch = FetchType.LAZY)
    public List<DigitalInput> getDigitalInputs() {
        return digitalInputs;
    }

    public void setDigitalInputs(List<DigitalInput> digitalInputList) {
        this.digitalInputs = digitalInputList;
    }

    @OneToMany(mappedBy = "processControlObject", fetch = FetchType.LAZY)
    public List<AnalogOutput> getAnalogOutputs() {
        return analogOutputs;
    }

    public void setAnalogOutputs(List<AnalogOutput> analogOutputList) {
        this.analogOutputs = analogOutputList;
    }

    @OneToMany(mappedBy = "processControlObject", fetch = FetchType.LAZY)
    public List<DigitalOutput> getDigitalOutputs() {
        return digitalOutputs;
    }

    public void setDigitalOutputs(List<DigitalOutput> digitalOutputList) {
        this.digitalOutputs = digitalOutputList;
    }

    @Override
    public String toString() {
        return getSymbol() + " " + getName() + " " + getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessControlObject)) return false;

        ProcessControlObject that = (ProcessControlObject) o;

        if (getSymbol() != null ? !getSymbol().equals(that.getSymbol()) : that.getSymbol() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return !(getDepartment() != null ? !getDepartment().equals(that.getDepartment()) : that.getDepartment() != null);

    }

    @Override
    public int hashCode() {
        int result = getSymbol() != null ? getSymbol().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDepartment() != null ? getDepartment().hashCode() : 0);
        return result;
    }
}
