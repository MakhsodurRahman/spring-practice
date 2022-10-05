package com.spring5.practice.dao;

import com.spring5.practice.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import java.util.List;

public interface UserDAO {
    public User insert(User user);
    public List<User> getAll();
   public void delete(Long theId);
    public User getById(Long theId) ;
    public void update(User user);
   public User findByUsername(String username) throws UsernameNotFoundException;


}
