package rl.signaltable.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class Department {

    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    private Set<ProcessControlObject> processControlObjects;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    public Set<ProcessControlObject> getProcessControlObjects() {
        return processControlObjects;
    }

    public void setProcessControlObjects(Set<ProcessControlObject> processControlObjects) {
        this.processControlObjects = processControlObjects;
    }

    @Column(name = "name", nullable = false)
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

    @Override
    public String toString() {
        return id + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;

        Department department = (Department) o;

        return !(getName() != null ? !getName().equals(department.getName()) : department.getName() != null);

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}