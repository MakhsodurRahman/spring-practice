package com.spring5.practice.dao;

import com.spring5.practice.entity.User;
import com.spring5.practice.model.FormObject;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void createUser(User user) {
        user.setId(System.currentTimeMillis());
        var session = sessionFactory.getCurrentSession();
        try {
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
