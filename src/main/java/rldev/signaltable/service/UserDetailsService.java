package rldev.signaltable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rldev.signaltable.dao.UserDao;
import rldev.signaltable.dao.RoleDao;
import rldev.signaltable.entity.User;
import rldev.signaltable.entity.Role;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired private UserDao userDao;
    @Autowired private RoleDao roleDao;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDao.findByUsername(s);
        Set<Role> roles = new HashSet<Role>(roleDao.findByUsername(s));

        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        for(Role role : roles) {
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
