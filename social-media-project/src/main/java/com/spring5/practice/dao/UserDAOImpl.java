package com.spring5.practice.dao;

import com.spring5.practice.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserDAOImpl implements UserDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public User insert(User user) {
        Session session = sessionFactory.getCurrentSession();

        try{
            session.saveOrUpdate(user);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return user;
    }

    public List<User> getAll(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User", User.class);
        List<User> userList = query.list();
        return userList;
    }

    @Override
    public void delete(Long theId) {
        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("delete from User where id=:userId").setParameter("userId",theId);
//        query.executeUpdate();

        User user = session.load(User.class, theId);
        session.delete(user);
        session.flush();
    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }



    public User findByUsername(String username) throws UsernameNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        User user = null;

        try {
            String hql = "FROM User WHERE name= :name";

            Query query = session.createQuery(hql, User.class).setParameter("name", username);
            user = (User) query.getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return user;
    }


    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(user);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }
}
