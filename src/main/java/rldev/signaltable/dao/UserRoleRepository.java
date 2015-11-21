package rldev.signaltable.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rldev.signaltable.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    List<UserRole> findByUsername(String username);
}
