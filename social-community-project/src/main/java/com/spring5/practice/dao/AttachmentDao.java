package com.spring5.practice.dao;

import com.spring5.practice.entity.Attachment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AttachmentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Attachment attachment) {
        Session session = sessionFactory.getCurrentSession();
        try {
//            var tx = session.getTransaction();
//            if (tx == null)
//                tx = session.beginTransaction();
            session.save(attachment);
//            tx.commit();
        }catch (Exception e){
            session.getTransaction().rollback();
        }

        session.flush();
    }
}
