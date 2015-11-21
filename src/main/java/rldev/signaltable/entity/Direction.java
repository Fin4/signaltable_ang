package rldev.signaltable.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "DIRECTION")
public class Direction implements Persistent {

    private Long id;
    private String name;
    private Set<APCSObject> apcsObjects;

    @Id
    @GeneratedValue(generator="increment")
    //@GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "direction", fetch = FetchType.LAZY)
    public Set<APCSObject> getApcsObjects() {
        return apcsObjects;
    }

    public void setApcsObjects(Set<APCSObject> apcsObjects) {
        this.apcsObjects = apcsObjects;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direction)) return false;

        Direction direction = (Direction) o;

        return !(getName() != null ? !getName().equals(direction.getName()) : direction.getName() != null);

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}