package rldev.signaltable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rldev.signaltable.dao.UserRepository;
import rldev.signaltable.entity.User;
import rldev.signaltable.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired private UserRepository userRepository;

    public void save(User persistent) {
        userRepository.save(persistent);
    }

    public void update(User persistent) {
        userRepository.save(persistent);
    }

    public void delete(User persistent) {
        userRepository.delete(persistent);
    }

    public void deleteById(Long id) {
        userRepository.delete(id);
    }

    public User getById(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
