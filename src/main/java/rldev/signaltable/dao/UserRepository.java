package rldev.signaltable.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rldev.signaltable.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
