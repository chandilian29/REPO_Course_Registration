/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.Faculty;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Uguudei
 */

@Transactional
public class FacultyDAO implements IFacultyDAO{
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
       
    @Override
    public List<Faculty> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Faculty");
        return q.list();
    }

    @Override
    public void add(Faculty faculty) {
        sessionFactory.getCurrentSession().persist(faculty);
    }

    @Override
    public Faculty get(int id) {
        return (Faculty) sessionFactory.getCurrentSession().load(Faculty.class, id);
    }

    @Override
    public boolean isUserExist(String user_id){
        Query qr = sessionFactory.getCurrentSession().createQuery("from Faculty where username = :username");
        qr.setParameter("username", user_id);
        boolean result = true;
        if(qr.list().isEmpty())
            result = false;
        return  result;//(qr.list().get(0) != null);
    }
    
    @Override
    public void update(int facultyId, Faculty faculty) {
        faculty.setId(facultyId);
        sessionFactory.getCurrentSession().merge(faculty);
    }

    @Override
    public void delete(int facultyId) {
        Faculty f = get(facultyId);
        sessionFactory.getCurrentSession().delete(f);
    }
}
