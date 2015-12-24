package rl.signaltable.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rl.signaltable.core.entity.Role;
import rl.signaltable.core.dao.UserDao;
import rl.signaltable.core.dao.RoleDao;
import rl.signaltable.core.entity.User;

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
