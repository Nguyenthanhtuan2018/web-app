package com.microservices.springwebapp.authentication.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservices.springwebapp.entity.RoleEntity;
import com.microservices.springwebapp.entity.UserEntity;
import com.microservices.springwebapp.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userService.selectByName2(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<RoleEntity> roles = user.getRoles();
        for (RoleEntity role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(), grantedAuthorities);
    }

}