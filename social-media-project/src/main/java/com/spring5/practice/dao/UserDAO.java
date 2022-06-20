package com.spring5.practice.dao;

import com.spring5.practice.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.List;
import java.util.Optional;

public interface UserDAO {
    public void insert(User user);
    public List<User> getAll();
   public void delete(Long theId);
   public User findByUsername(String username) throws UsernameNotFoundException;


}
