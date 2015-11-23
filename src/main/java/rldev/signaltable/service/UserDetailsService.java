package rldev.signaltable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rldev.signaltable.dao.UserRepository;
import rldev.signaltable.dao.UserRoleRepository;
import rldev.signaltable.entity.User;
import rldev.signaltable.entity.UserRole;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired private UserRepository userRepository;
    @Autowired private UserRoleRepository userRoleRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(s);
        Set<UserRole> roles = new HashSet<UserRole>(userRoleRepository.findByUsername(s));

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for(UserRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                authorities
        );
    }
}
