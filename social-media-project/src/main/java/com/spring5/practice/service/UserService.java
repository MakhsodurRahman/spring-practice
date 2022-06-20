package com.spring5.practice.service;

import com.spring5.practice.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;



    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userFromDb = userDAO.findByUsername(username);
        if (userFromDb == null) {
            throw new UsernameNotFoundException(username);
        }
        //SecurityContextHolder.getContext().getAuthentication();

        List<GrantedAuthority> authorities = new ArrayList<>(Collections.emptyList());

        authorities.add((GrantedAuthority) () -> userFromDb.getRole().name());

        return new User(userFromDb.getName(), userFromDb.getPassword(), authorities);

    }
}
