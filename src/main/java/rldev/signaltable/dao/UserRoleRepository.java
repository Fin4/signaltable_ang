package rldev.signaltable.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rldev.signaltable.entity.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUsername(String username);
}
