package com.spring5.practice.dao;

import com.spring5.practice.entity.Status;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class StatusDAOImpl implements StatusDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(Status status){
        Session session = sessionFactory.getCurrentSession();

        try {
            session.save(status);
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        session.flush();
    }

    @Override
    public List<Status> getAll() {
        Session session = sessionFactory.getCurrentSession();

        Query<Status> query = session.createQuery("from Status", Status.class);
        List<Status> statusList = query.list();
        return statusList;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
//        Query query = session.createQuery("delete from Status where id =:statusId");
//        query.setParameter("statusId",id);
//        query.executeUpdate();

        Status status = session.load(Status.class, id);
        session.delete(status);
        session.flush();

    }
}
