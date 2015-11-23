package rldev.signaltable.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import rldev.signaltable.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
