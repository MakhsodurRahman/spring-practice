package com.spring5.practice.dao.scp;

import com.spring5.practice.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(Location location){
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(location);

        }catch (Exception e){
            session.getTransaction().rollback();
        }
        session.flush();
    }



}
