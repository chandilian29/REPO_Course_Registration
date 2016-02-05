/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edu.mum.dao;

import com.mum.edu.domain.Administrator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Uguudei
 */

@Transactional
public class AdministratorDAO implements IAdministratorDAO{
    private SessionFactory sessionFactory;

    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
       
    @Override
    public List<Administrator> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Administrator");
        return q.list();
    }

    @Override
    public void add(Administrator admin) {
        sessionFactory.getCurrentSession().persist(admin);
    }

    @Override
    public Administrator get(int id) {
        return (Administrator) sessionFactory.getCurrentSession().load(Administrator.class, id);
    }

    @Override
    public boolean isUserExist(String user_id){
        Query qr = sessionFactory.getCurrentSession().createQuery("from Administrator where username = :username");
        qr.setParameter("username", user_id);
        boolean result = true;
        if(qr.list().isEmpty())
            result = false;
        return  result;//(qr.list().get(0) != null);
    }
    
    @Override
    public void update(int adminId, Administrator admin) {
        admin.setId(adminId);
        sessionFactory.getCurrentSession().merge(admin);
    }

    @Override
    public void delete(int adminId) {
        Administrator a = get(adminId);
        sessionFactory.getCurrentSession().delete(a);
    }
}
