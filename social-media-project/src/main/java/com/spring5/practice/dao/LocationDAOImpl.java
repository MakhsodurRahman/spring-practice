package com.spring5.practice.dao;

import com.spring5.practice.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class LocationDAOImpl implements LocationDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void insert(Location location) {
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(location);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

    }

    public List<Location> getAll(){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("SELECT s FROM Location s", Location.class);
        List<Location> locationList = query.getResultList();
        return locationList;
    }

    @Override
    public void update(Location location) {

        Session session = sessionFactory.getCurrentSession();

        try {
            session.saveOrUpdate(location);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();

    }

    @Override
    public Location getByName(String name){
        Location location = null;
        Session session = sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("FROM Location WHERE locationName = :name").setParameter("name",name);
            location = (Location) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
        return location;
    }
}
