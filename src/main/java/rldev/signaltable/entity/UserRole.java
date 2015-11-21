package rldev.signaltable.entity;



import javax.persistence.*;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

    private Long id;
    private String role;
    private String username;

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ROLE")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (getRole() != null ? !getRole().equals(userRole.getRole()) : userRole.getRole() != null) return false;
        return !(getUsername() != null ? !getUsername().equals(userRole.getUsername()) : userRole.getUsername() != null);

    }

    @Override
    public int hashCode() {
        int result = getRole() != null ? getRole().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        return result;
    }
}
