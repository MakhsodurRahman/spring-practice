package com.spring5.practice.dao;

import com.spring5.practice.entity.StudentForm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(StudentForm studentForm){
        studentForm.setId(System.currentTimeMillis());
        Session session = sessionFactory.getCurrentSession();
        try {
            session.save(studentForm);
        }catch (Exception e){
            session.getTransaction().rollback();
        }

        session.flush();
    }

//    public List<StudentForm> getAll(){
//        var session = sessionFactory.getCurrentSession();
//        String hqlQuery = "SELECT s FROM student_data2 s";
//
//        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery, StudentForm.class);
//        List<StudentForm> studentList = query.list();
//
//        return studentList;
//    }

    public List<StudentForm> getAll(){
        var session = sessionFactory.getCurrentSession();
        String hqlQuery = "SELECT s FROM StudentForm s";

        Query query = sessionFactory.getCurrentSession().createQuery(hqlQuery,StudentForm.class);
        List<StudentForm> studentFormList = query.list();
        return studentFormList;
    }

}
